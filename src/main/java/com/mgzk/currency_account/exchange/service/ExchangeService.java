package com.mgzk.currency_account.exchange.service;

import java.math.BigDecimal;
import java.util.UUID;

public interface ExchangeService {
  void exchange(UUID accountIdentifier, BigDecimal amount, String sourceCurrencyCode, String destinationCurrencyCode);
}
