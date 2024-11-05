package com.example.bankingApllicatrion.BankingApplication.Service;

import com.example.bankingApllicatrion.BankingApplication.Entity.Account;
import com.example.bankingApllicatrion.BankingApplication.Entity.TransactionType;
import com.example.bankingApllicatrion.BankingApplication.Entity.Transiction;
import com.example.bankingApllicatrion.BankingApplication.Reposiritory.Accountrepo;
import com.example.bankingApllicatrion.BankingApplication.Reposiritory.Transactionrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
@Service
public class Userservice {
    @Autowired
   private Accountrepo accountrepo;
    @Autowired
    private Transactionrepo transactionrepo;
public Account findByaccount(long accountno){
return accountrepo.findByaccount( accountno);
}
public Account  createAccount(Account account){
    Account account1 =accountrepo.save(account);
    return account1;
}
public String Deposite(long accountno,int amount){
Account account =findByaccount(accountno);
account.setBalance(account.getBalance()+amount);


    Transiction transaction = new Transiction();
    transaction.setAmount(amount);
    transaction.setTimestamp(LocalDateTime.now());
    transaction.setType(TransactionType.CREDIT);
    transaction.setAccount(account);
    transactionrepo.save(transaction);
return "Deposit Sucuessfully \n "+account;
}
    public String Withdraw(long accountno,int amount) {
        Account account = findByaccount(accountno);
        if(account.getBalance()<amount){
            return "insufficent Balance \n"+account;
        }else{
            account.setBalance(account.getBalance()-amount);
            Transiction transaction = new Transiction();
            transaction.setAmount(amount);
            transaction.setTimestamp(LocalDateTime.now());
            transaction.setType(TransactionType.DEBIT);
            transaction.setAccount(account);
            transactionrepo.save(transaction);

            return "Withdraw Sucessfully"+account;
        }


    }
    public String Upadtedata(long accountno, String name, String contactno, String address) {
        Account account = findByaccount(accountno);

        if (name != null && !name.isEmpty()) {
            account.setName(name);
        }
        if (contactno != null && !contactno.isEmpty()) {
            account.setContactno(contactno);
        }
        if (address != null && !address.isEmpty()) {
            account.setAddress(address);
        }

        accountrepo.save(account);

        return "Update Successfully: " + account;
    }


    public List<Transiction> passbookbyacc(long accountno) {
   List<Transiction> t=transactionrepo.findByacc(accountno);
   return t;
    }
}
