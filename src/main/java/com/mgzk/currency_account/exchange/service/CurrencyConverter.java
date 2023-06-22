package com.mgzk.currency_account.exchange.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyConverter {

  private final ExchangeRateProvider exchangeRateProvider;

  private final TransactionTypeService transactionTypeService;

  public BigDecimal convert(BigDecimal amount, String sourceCurrencyCode, String destinationCurrencyCode) {
    BigDecimal rate = exchangeRateProvider.get(sourceCurrencyCode, destinationCurrencyCode);

    TransactionTypeService.TransactionType transactionType = transactionTypeService.get(sourceCurrencyCode, destinationCurrencyCode);

    return switch (transactionType) {
      case PURCHASE -> amount.divide(rate, 2, RoundingMode.HALF_UP);
      case SELL -> amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    };
  }
}
