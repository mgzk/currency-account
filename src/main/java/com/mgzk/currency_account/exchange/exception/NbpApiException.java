package com.mgzk.currency_account.exchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class NbpApiException extends RuntimeException {
  public NbpApiException(Exception cause) {
    super(cause);
  }
}
