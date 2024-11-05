package com.example.bankingApllicatrion.BankingApplication.Reposiritory;

import com.example.bankingApllicatrion.BankingApplication.Entity.Account;
import com.example.bankingApllicatrion.BankingApplication.Entity.Transiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Transactionrepo  extends JpaRepository<Transiction,Integer> {
@Query(value = "select * from transiction where account_id =? ",nativeQuery = true)
public List<Transiction> findByacc(long accountno);
}
