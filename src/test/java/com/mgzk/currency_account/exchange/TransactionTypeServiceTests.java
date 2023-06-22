package com.mgzk.currency_account.exchange;

import com.mgzk.currency_account.exchange.exception.InvalidCurrencyCodeException;
import com.mgzk.currency_account.exchange.service.TransactionTypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionTypeServiceTests {

  private final TransactionTypeService transactionTypeService;

  @Autowired
  public TransactionTypeServiceTests(TransactionTypeService transactionTypeService) {
    this.transactionTypeService = transactionTypeService;
  }

  @Test
  public void get_plnToUsdExchange_returnPurchase() {
    //given
    String sourceCurrencyCode = "PLN";
    String destinationCurrencyCode = "USD";

    //when
    TransactionTypeService.TransactionType transactionType = transactionTypeService.get(sourceCurrencyCode, destinationCurrencyCode);

    //then
    Assertions.assertEquals(TransactionTypeService.TransactionType.PURCHASE, transactionType);
  }

  @Test
  public void get_usdToPlnExchange_returnSell() {
    //given
    String sourceCurrencyCode = "USD";
    String destinationCurrencyCode = "PLN";

    //when
    TransactionTypeService.TransactionType transactionType = transactionTypeService.get(sourceCurrencyCode, destinationCurrencyCode);

    //then
    Assertions.assertEquals(TransactionTypeService.TransactionType.SELL, transactionType);
  }

  @Test
  public void get_usdToUsdExchange_throwsException() {
    //given
    String sourceCurrencyCode = "USD";
    String destinationCurrencyCode = "USD";

    //when, then
    Assertions.assertThrows(InvalidCurrencyCodeException.class, () -> {
      transactionTypeService.get(sourceCurrencyCode, destinationCurrencyCode);
    });
  }

  @Test
  public void get_plnToPlnExchange_throwsException() {
    //given
    String sourceCurrencyCode = "PLN";
    String destinationCurrencyCode = "PLN";

    //when, then
    Assertions.assertThrows(InvalidCurrencyCodeException.class, () -> {
      transactionTypeService.get(sourceCurrencyCode, destinationCurrencyCode);
    });
  }
}
