package cn.ronghuanet._03transfer.service;

import java.math.BigDecimal;

import cn.ronghuanet._03transfer.domain.Account;

public interface IAccountService {

	String transfer(Account out,Account in,BigDecimal money);
}
