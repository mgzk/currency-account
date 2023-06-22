package com.mgzk.currency_account.account.service;

import com.mgzk.currency_account.account.model.Account;
import com.mgzk.currency_account.account.model.Balance;
import com.mgzk.currency_account.account.model.BalanceId;
import java.math.BigDecimal;

public class BalanceFactory {
  public static Balance create(Account account, String currency) {
    return Balance.builder()
      .id(BalanceId.builder()
        .currency(currency)
        .build())
      .amount(BigDecimal.ZERO)
      .account(account)
      .build();
  }
}
