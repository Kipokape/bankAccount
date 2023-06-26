package com.example.bankAccountLoader;

import com.example.bankAccountLoader.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {


}
