package com.mgzk.currency_account.account.controller;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Balance {

  @PositiveOrZero
  private BigDecimal amount;

  @Size(min = 3, max = 3, message = "iso 4217")
  private String currency;
}
