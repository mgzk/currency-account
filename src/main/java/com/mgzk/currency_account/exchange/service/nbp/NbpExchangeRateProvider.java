package com.mgzk.currency_account.exchange.service.nbp;

import com.mgzk.currency_account.exchange.service.ExchangeRateProvider;
import com.mgzk.currency_account.exchange.service.TransactionTypeService;
import java.math.BigDecimal;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NbpExchangeRateProvider implements ExchangeRateProvider {

  @Value("${exchange.rate.url}")
  private String url;

  private final NbpApiClient client;

  private final TransactionTypeService transactionTypeService;

  private final NbpExchangeRateParser parser;

  @Override
  public BigDecimal get(String sourceCurrencyCode, String destinationCurrencyCode) {
    TransactionTypeService.TransactionType transactionType = transactionTypeService.get(sourceCurrencyCode, destinationCurrencyCode);

    URI uri = switch (transactionType) {
      case PURCHASE -> NbpApiUriFactory.get(url, destinationCurrencyCode);
      case SELL -> NbpApiUriFactory.get(url, sourceCurrencyCode);
    };

    String responseBody = client.get(uri);
    return parser.parse(responseBody);
  }
}
