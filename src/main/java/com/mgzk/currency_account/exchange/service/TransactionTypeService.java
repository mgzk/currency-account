package com.mgzk.currency_account.exchange.service;

import com.mgzk.currency_account.account.properties.AccountCurrencyProperties;
import com.mgzk.currency_account.exchange.exception.InvalidCurrencyCodeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionTypeService {

  private final AccountCurrencyProperties properties;

  public TransactionType get(String sourceCurrencyCode, String destinationCurrencyCode) {
    if (sourceCurrencyCode.equals(destinationCurrencyCode)) {
      throw new InvalidCurrencyCodeException("Source currency and destination currency can not be same");
    } else if (sourceCurrencyCode.equalsIgnoreCase(properties.getBase())) {
      return TransactionType.PURCHASE;
    } else if (destinationCurrencyCode.equalsIgnoreCase(properties.getBase())) {
      return TransactionType.SELL;
    }

    throw new InvalidCurrencyCodeException("Source or destination currency must be: " + properties.getBase());
  }

  public enum TransactionType {
    PURCHASE,
    SELL
  }
}
