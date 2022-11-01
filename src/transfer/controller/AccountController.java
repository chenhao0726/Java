package transfer.controller;

import org.junit.Test;
import transfer.dao.IAccountDao;
import transfer.dao.impl.AccountDaoImpl;
import transfer.domain.Account;
import transfer.service.IAccountService;
import transfer.service.impl.AccountServiceImpl;

import java.math.BigDecimal;

public class AccountController {
    private IAccountDao iad = new AccountDaoImpl();
    private IAccountService iaService = new AccountServiceImpl();

    @Test
    public void testGetById() {
        Account account = iad.queryById(1L);
        System.out.println(account);
    }

    @Test
    public void testFerService() {
        Account account = iad.queryById(1L);
        Account account1 = iad.queryById(2L);
        String transfer = iaService.transfer(account, account1, new BigDecimal(200));
        System.out.println(transfer);
    }

}
