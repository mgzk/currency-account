package com.mgzk.currency_account.exchange.service.nbp;

import com.mgzk.currency_account.exchange.exception.NbpApiException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NbpApiClient {
  public String get(URI uri) {
    try {
      HttpRequest request = HttpRequest.newBuilder()
        .uri(uri)
        .GET()
        .build();
      HttpResponse<String> response = HttpClient.newHttpClient()
        .send(request, HttpResponse.BodyHandlers.ofString());
      return response.body();
    } catch (InterruptedException | IOException ex) {
      log.error(ex.getMessage());
      throw new NbpApiException(ex);
    }
  }
}
