package key.test;

import key.dao.IUserDao;
import key.dao.impl.UserDaoImpl;
import key.domain.User;
import org.junit.Test;

public class KeyTest {
	private IUserDao dao = new UserDaoImpl();
	@Test
	public void testStatementKey() throws Exception {
		User u = new User( "wdl", "123",  45);
		Long saveUser = dao.saveUser(u);
		System.out.println(saveUser);
	}
	@Test
	public void testStatementKey1() throws Exception {
		User u = new User( "zzz", "123",  45);
		Long saveUser = dao.saveUserPS(u);
		System.out.println(saveUser);
	}
}
