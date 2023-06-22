package com.mgzk.currency_account.account.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateAccountRequest {

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @Valid
  @NotNull
  private Balance initialBalance;
}
