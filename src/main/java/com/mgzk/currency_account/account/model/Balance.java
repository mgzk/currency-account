package com.mgzk.currency_account.account.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Balance {
  @EmbeddedId
  private BalanceId id;

  @Column(nullable = false, scale = 2)
  private BigDecimal amount;

  @MapsId("accountId")
  @ManyToOne
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Account account;
}
