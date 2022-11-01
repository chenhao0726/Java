package transfer.dao;

import transfer.domain.Account;

import java.math.BigDecimal;

public interface IAccountDao {
	/**
	 * 转账
	 */
	boolean transfer(Account out, Account in, BigDecimal money);
	/**
	 * 根据id查用户
	 */
	Account queryById(Long id);
}
