package com.mgzk.currency_account.account.mapper;

import com.mgzk.currency_account.account.controller.Balance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BalanceMapper {

  @Mapping(source = "id.currency", target = "currency")
  Balance map(com.mgzk.currency_account.account.model.Balance balance);

  @Mapping(source = "currency", target = "id.currency")
  com.mgzk.currency_account.account.model.Balance map(Balance balance);
}
