package com.mgzk.currency_account.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {
  public AccountNotFoundException(Long id) {
    super(String.format("Account not found, id: %d", id));
  }
}
