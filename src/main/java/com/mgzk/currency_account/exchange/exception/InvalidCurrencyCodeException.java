package com.mgzk.currency_account.exchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCurrencyCodeException extends RuntimeException {
  public InvalidCurrencyCodeException(String currencyCode) {
    super(String.format("Invalid currency code: %s", currencyCode));
  }
}
