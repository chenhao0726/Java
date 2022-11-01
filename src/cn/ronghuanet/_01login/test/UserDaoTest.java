package cn.ronghuanet._01login.test;

import org.junit.Test;

import cn.ronghuanet._01login.dao.IUserDao;
import cn.ronghuanet._01login.dao.impl.UserDaoImpl;
import cn.ronghuanet._01login.domain.User;

public class UserDaoTest {

	private IUserDao dao= new UserDaoImpl();
	
	@Test
	public void testGetUser() {
		User user = dao.getUserByNameAndPwd(new User("zs", "123"));
		System.out.println(user);
	}

}
