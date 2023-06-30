package com.mgzk.currency_account.account.repository;

import com.mgzk.currency_account.account.model.Account;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
  Optional<Account> findByIdentifier(UUID identifier);
}
