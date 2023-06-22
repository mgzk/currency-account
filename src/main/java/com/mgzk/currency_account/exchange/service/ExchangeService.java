package com.mgzk.currency_account.exchange.service;

import java.math.BigDecimal;

public interface ExchangeService {
  void exchange(Long accountId, BigDecimal amount, String sourceCurrencyCode, String destinationCurrencyCode);
}
