package com.example.tupaph13622_assjv6.service.impl;

import com.example.tupaph13622_assjv6.respository.AccountRepository;
import com.example.tupaph13622_assjv6.entity.Account;
import com.example.tupaph13622_assjv6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accRep;
    @Override
    public Account findById(String username) {
        return accRep.findById(username).get();
    }
}
