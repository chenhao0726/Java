package key.dao;

import key.domain.User;

public interface IUserDao {
	Long saveUser(User u) throws Exception;
	Long saveUserPS(User u) throws Exception;
}
