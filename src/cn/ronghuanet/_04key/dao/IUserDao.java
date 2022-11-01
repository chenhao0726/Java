package cn.ronghuanet._04key.dao;

import cn.ronghuanet._04key.domain.User;

public interface IUserDao {
	Long saveUser(User u) throws Exception;
	Long saveUserPS(User u) throws Exception;
}
