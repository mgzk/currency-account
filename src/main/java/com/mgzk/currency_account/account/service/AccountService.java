package com.mgzk.currency_account.account.service;

import com.mgzk.currency_account.account.controller.AccountResponse;
import java.math.BigDecimal;

public interface AccountService {
  Long create(String firstName, String lastName, BigDecimal initialAmount, String initialCurrency);

  AccountResponse findById(Long id);
}
