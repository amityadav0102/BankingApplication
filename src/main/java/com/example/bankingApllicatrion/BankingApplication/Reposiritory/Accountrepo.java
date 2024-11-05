package com.example.bankingApllicatrion.BankingApplication.Reposiritory;

import com.example.bankingApllicatrion.BankingApplication.Entity.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Accountrepo extends JpaRepository<Account, Long> {

@Query(value = "select * from Account where id=?",nativeQuery = true)
   public Account findByaccount(long accountno);
}
