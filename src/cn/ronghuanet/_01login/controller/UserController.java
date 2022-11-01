package cn.ronghuanet._01login.controller;

import org.junit.Test;

import cn.ronghuanet._01login.domain.User;
import cn.ronghuanet._01login.service.IUserService;
import cn.ronghuanet._01login.service.impl.UserServiceImpl;

public class UserController {
	
	private IUserService servcie = new UserServiceImpl();
	
	@Test
	public void loginByUser() {
		
		boolean loginByUser = servcie.loginByUser(new User("zs", "1234 or 1=1"));
		System.out.println(loginByUser?"登陆成功":"登陆失败");
	}
	
	@Test
	public void loginByUserName() {
		
		boolean loginByUser = servcie.loginByUserName(new User("zs1", "1234"));
		System.out.println(loginByUser?"登陆成功":"登陆失败");
	}
	@Test
	public void loginByPst() {
//		"select * from t_user where name = 'zs' and password='1234 or 1=1'"
		boolean loginByUser = servcie.loginByPst(new User("zs", "1234 or 1=1"));
		System.out.println(loginByUser?"登陆成功":"登陆失败");
	}
}
