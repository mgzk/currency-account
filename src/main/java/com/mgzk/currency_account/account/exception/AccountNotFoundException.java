package com.mgzk.currency_account.account.exception;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {
  public AccountNotFoundException(UUID identifier) {
    super(String.format("Account not found, identifier: %s", identifier));
  }
}
