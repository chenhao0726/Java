package transfer.service;

import transfer.domain.Account;

import java.math.BigDecimal;

public interface IAccountService {

	// 转账
	String transfer(Account out, Account in, BigDecimal money);
}
