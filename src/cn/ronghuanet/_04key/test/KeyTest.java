package cn.ronghuanet._04key.test;

import org.junit.Test;

import cn.ronghuanet._04key.dao.IUserDao;
import cn.ronghuanet._04key.dao.impl.UserDaoImpl;
import cn.ronghuanet._04key.domain.User;

public class KeyTest {
	private IUserDao dao = new UserDaoImpl();
	@Test
	public void testStatementKey() throws Exception {
		User u = new User( "wdl", "123", 1, 45);
		Long saveUser = dao.saveUser(u);
		System.out.println(saveUser);
	}
	@Test
	public void testStatementKey1() throws Exception {
		User u = new User( "zzz", "123", 1, 45);
		Long saveUser = dao.saveUserPS(u);
		System.out.println(saveUser);
	}
}
