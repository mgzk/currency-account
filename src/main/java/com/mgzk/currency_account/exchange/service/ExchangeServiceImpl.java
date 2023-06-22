package com.mgzk.currency_account.exchange.service;

import com.mgzk.currency_account.account.exception.AccountNotFoundException;
import com.mgzk.currency_account.account.model.Account;
import com.mgzk.currency_account.account.model.Balance;
import com.mgzk.currency_account.account.repository.AccountRepository;
import com.mgzk.currency_account.exchange.exception.InsufficientBalanceException;
import com.mgzk.currency_account.exchange.exception.InvalidCurrencyCodeException;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

  private final AccountRepository accountRepository;

  private final CurrencyConverter currencyConverter;

  @Transactional
  @Override
  public void exchange(Long accountId, BigDecimal sourceAmount, String sourceCurrencyCode, String destinationCurrencyCode) {
    Account account = accountRepository.findById(accountId)
      .orElseThrow(() -> new AccountNotFoundException(accountId));

    Balance sourceBalance = filter(account, sourceCurrencyCode);

    if (sourceBalance.getAmount().compareTo(sourceAmount) < 0) {
      throw new InsufficientBalanceException(String.format("Insufficient balance on account: %d, currency: %s", accountId, sourceCurrencyCode));
    }

    Balance destinationBalance = filter(account, destinationCurrencyCode);

    BigDecimal destinationAmount = currencyConverter.convert(sourceAmount, sourceCurrencyCode, destinationCurrencyCode);

    updateSource(sourceBalance, sourceAmount);
    updateDestination(destinationBalance, destinationAmount);

    accountRepository.save(account);
  }

  private Balance filter(Account account, String currencyCode) {
    return account.getBalances().stream()
      .filter(balance -> balance.getId().getCurrency().equals(currencyCode))
      .findAny()
      .orElseThrow(() -> new InvalidCurrencyCodeException(currencyCode));
  }

  private void updateSource(Balance source, BigDecimal amount) {
    source.setAmount(source.getAmount().subtract(amount));
  }

  private void updateDestination(Balance destination, BigDecimal amount) {
    destination.setAmount(destination.getAmount().add(amount));
  }
}
