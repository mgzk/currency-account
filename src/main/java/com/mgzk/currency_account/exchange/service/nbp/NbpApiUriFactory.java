package com.mgzk.currency_account.exchange.service.nbp;

import java.net.URI;
import lombok.SneakyThrows;

public class NbpApiUriFactory {
  @SneakyThrows
  public static URI get(String source, String currency) {
    return new URI(source + currency.toLowerCase() + "/?format=json");
  }
}
