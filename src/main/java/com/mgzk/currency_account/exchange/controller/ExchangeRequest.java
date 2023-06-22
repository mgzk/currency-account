package com.mgzk.currency_account.exchange.controller;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ExchangeRequest {
  @Positive
  private BigDecimal amount;

  @Size(min = 3, max = 3, message = "iso 4217")
  private String sourceCurrency;

  @Size(min = 3, max = 3, message = "iso 4217")
  private String destinationCurrency;
}
