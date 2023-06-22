package com.mgzk.currency_account.exchange.controller;

import com.mgzk.currency_account.exchange.service.ExchangeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts/{id}/exchanges")
@RequiredArgsConstructor
public class ExchangeController {

  private final ExchangeService exchangeService;

  @PostMapping
  public ResponseEntity<Void> exchange(@PathVariable Long id,
                                       @Valid @RequestBody ExchangeRequest request) {
    exchangeService.exchange(id, request.getAmount(), request.getSourceCurrency(), request.getDestinationCurrency());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
