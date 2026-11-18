package org.ngueoko.accountservice.repository;

import org.ngueoko.accountservice.domain.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<AccountTransaction, UUID> {
    List<AccountRepository> findByAccountId(UUID accountId);
}
