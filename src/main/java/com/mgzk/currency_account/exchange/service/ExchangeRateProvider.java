package com.mgzk.currency_account.exchange.service;

import java.math.BigDecimal;

public interface ExchangeRateProvider {
  BigDecimal get(String sourceCurrencyCode, String destinationCurrencyCode);
}
