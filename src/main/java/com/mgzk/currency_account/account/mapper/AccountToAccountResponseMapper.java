package com.mgzk.currency_account.account.mapper;

import com.mgzk.currency_account.account.model.Account;
import com.mgzk.currency_account.account.controller.AccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(uses = BalanceMapper.class, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountToAccountResponseMapper {
  AccountResponse map(Account account);
}
