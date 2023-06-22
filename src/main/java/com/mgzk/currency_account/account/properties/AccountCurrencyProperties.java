package com.mgzk.currency_account.account.properties;

import java.util.Set;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("account.currency")
public class AccountCurrencyProperties {
  private String base;

  private Set<String> supported;
}
