package com.mgzk.currency_account.account.repository;

import com.mgzk.currency_account.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
