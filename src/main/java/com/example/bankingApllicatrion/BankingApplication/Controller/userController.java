package com.example.bankingApllicatrion.BankingApplication.Controller;

import com.example.bankingApllicatrion.BankingApplication.Entity.Account;
import com.example.bankingApllicatrion.BankingApplication.Entity.Transiction;
import com.example.bankingApllicatrion.BankingApplication.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BankingSystem/api/user")
public class userController {
    @Autowired
   private Userservice userservice;
    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account){
        return userservice.createAccount(account);

    }
    @GetMapping("/check/{accountno}")
    public Account findByaccount(@PathVariable long accountno){
      return userservice.findByaccount(accountno);
    }
@PostMapping("/Deposite")
    public String Deposite (@RequestParam long accountno,@RequestParam int amount){

     return   userservice.Deposite(accountno,amount);

    }
    @PostMapping("/Withdraw")
    public String Withdraw(@RequestParam long accountno,@RequestParam int amount) {
      return userservice.Withdraw(accountno,amount);

    }
    @PostMapping("/updatedata")
    public String Upadtedata(
            @RequestParam long accountno,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String contactno,
            @RequestParam(required = false) String address) {
        return userservice.Upadtedata(accountno, name, contactno, address);
    }

    @GetMapping("/passbook")
    public List<Transiction > passbookbyacc(@RequestParam long accountno){
       return userservice.passbookbyacc(accountno);
    }


}
