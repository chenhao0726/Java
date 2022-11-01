package cn.ronghuanet._03transfer.service.impl;

import java.math.BigDecimal;

import cn.ronghuanet._03transfer.dao.IAccountDao;
import cn.ronghuanet._03transfer.dao.impl.AccountDaoImpl;
import cn.ronghuanet._03transfer.domain.Account;
import cn.ronghuanet._03transfer.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
	private IAccountDao dao = new AccountDaoImpl();

	@Override
	public String transfer(Account out, Account in, BigDecimal money) {
		// 判断传入账户是否存在
		if(out == null || in== null) {
			return "转账失败";
		}
		// 根据传入账户去查钱
		out = dao.queryById(out.getId());
		// 判断转出账户中的钱是否够转账
		if(out.getMoney().compareTo(money) < 0) {
			return "余额不足";
		}
		in = dao.queryById(in.getId());
		boolean transfer = dao.transfer(out, in, money);
		return transfer?"转账成功":"转账失败";
	}

}
