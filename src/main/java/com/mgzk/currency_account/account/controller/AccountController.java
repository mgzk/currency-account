package com.mgzk.currency_account.account.controller;

import com.mgzk.currency_account.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  @PostMapping
  public ResponseEntity<Long> create(@Valid @RequestBody CreateAccountRequest request) {
    Long id = accountService.create(request.getFirstName(), request.getLastName(), request.getInitialBalance().getAmount(), request.getInitialBalance().getCurrency());
    return new ResponseEntity<>(id, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AccountResponse> get(@PathVariable Long id) {
    AccountResponse response = accountService.findById(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
