package com.mgzk.currency_account.account.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponse {
  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @Valid
  @NotEmpty
  private Set<Balance> balances;
}
