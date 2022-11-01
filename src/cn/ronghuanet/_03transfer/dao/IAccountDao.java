package cn.ronghuanet._03transfer.dao;

import java.math.BigDecimal;

import cn.ronghuanet._03transfer.domain.Account;

public interface IAccountDao {
	/**
	 * 转账
	 */
	boolean transfer(Account out,Account in,BigDecimal money);
	/**
	 * 根据id查用户
	 */
	Account queryById(Long id);
}
