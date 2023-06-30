package com.mgzk.currency_account.account.service;

import com.mgzk.currency_account.account.controller.AccountResponse;
import java.math.BigDecimal;
import java.util.UUID;

public interface AccountService {
  UUID create(String firstName, String lastName, BigDecimal initialAmount, String initialCurrency);

  AccountResponse findByIdentifier(UUID identifier);
}
