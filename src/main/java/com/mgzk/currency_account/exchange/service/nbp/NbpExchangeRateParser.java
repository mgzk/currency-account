package com.mgzk.currency_account.exchange.service.nbp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class NbpExchangeRateParser {

  private final ObjectMapper objectMapper;

  public NbpExchangeRateParser() {
    this.objectMapper = new ObjectMapper();
  }

  @SneakyThrows
  public BigDecimal parse(String responseBody) {
    JsonNode node = objectMapper.readTree(responseBody);
    return node.get("rates").get(0).get("mid").decimalValue().setScale(4, RoundingMode.HALF_UP);
  }
}
