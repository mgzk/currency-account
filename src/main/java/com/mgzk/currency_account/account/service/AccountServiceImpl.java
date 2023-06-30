package com.mgzk.currency_account.account.service;

import com.mgzk.currency_account.account.controller.AccountResponse;
import com.mgzk.currency_account.account.exception.AccountNotFoundException;
import com.mgzk.currency_account.account.mapper.AccountToAccountResponseMapper;
import com.mgzk.currency_account.account.model.Account;
import com.mgzk.currency_account.account.model.Balance;
import com.mgzk.currency_account.account.properties.AccountCurrencyProperties;
import com.mgzk.currency_account.account.repository.AccountRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository repository;

  private final AccountCurrencyProperties properties;

  private final AccountToAccountResponseMapper mapper;

  @Transactional
  @Override
  public UUID create(String firstName, String lastName, BigDecimal initialAmount, String initialCurrency) {
    Set<Balance> balances = new HashSet<>();

    Account account = Account.builder()
      .identifier(UUID.randomUUID())
      .firstName(firstName)
      .lastName(lastName)
      .balances(balances)
      .build();

    properties.getSupported().stream()
      .map(currency -> BalanceFactory.create(account, currency))
      .forEach(balances::add);

    balances.stream()
      .filter(balance -> balance.getId().getCurrency().equals(initialCurrency))
      .findAny()
      .ifPresent(balance -> balance.setAmount(initialAmount));

    return repository.save(account).getIdentifier();
  }

  @Override
  public AccountResponse findByIdentifier(UUID identifier) {
    Account account = repository.findByIdentifier(identifier)
      .orElseThrow(() -> new AccountNotFoundException(identifier));

    return mapper.map(account);
  }
}
