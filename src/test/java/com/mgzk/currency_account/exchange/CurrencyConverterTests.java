package com.mgzk.currency_account.exchange;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.mgzk.currency_account.exchange.service.CurrencyConverter;
import com.mgzk.currency_account.exchange.service.ExchangeRateProvider;
import com.mgzk.currency_account.exchange.service.TransactionTypeService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CurrencyConverterTests {

  private final ExchangeRateProvider exchangeRateProvider;

  private final CurrencyConverter currencyConverter;

  private final BigDecimal RATE = new BigDecimal("4.0580");

  @Autowired
  CurrencyConverterTests(TransactionTypeService transactionTypeService) {
    this.exchangeRateProvider = Mockito.mock(ExchangeRateProvider.class);
    this.currencyConverter = new CurrencyConverter(exchangeRateProvider, transactionTypeService);
  }

  @Test
  void convert_plnToUsdConvert_returnAmount() {
    //given
    BigDecimal amount = new BigDecimal(50).setScale(2, RoundingMode.HALF_UP);
    String sourceCurrencyCode = "PLN";
    String destinationCurrencyCode = "USD";
    when(exchangeRateProvider.get(anyString(), anyString())).thenReturn(RATE);

    //when
    BigDecimal destinationAmount = currencyConverter.convert(amount, sourceCurrencyCode, destinationCurrencyCode);

    //then
    Assertions.assertEquals(new BigDecimal("12.32").setScale(2, RoundingMode.HALF_UP), destinationAmount);
  }

  @Test
  void convert_usdToPlnConvert_returnAmount() {
    //given
    BigDecimal amount = new BigDecimal("12.32");
    String sourceCurrencyCode = "USD";
    String destinationCurrencyCode = "PLN";
    when(exchangeRateProvider.get(anyString(), anyString())).thenReturn(RATE);

    //when
    BigDecimal destinationAmount = currencyConverter.convert(amount, sourceCurrencyCode, destinationCurrencyCode);

    //then
    Assertions.assertEquals(new BigDecimal("49.99").setScale(2, RoundingMode.HALF_UP), destinationAmount);
  }
}
