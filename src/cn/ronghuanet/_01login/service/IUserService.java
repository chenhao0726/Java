package cn.ronghuanet._01login.service;

import cn.ronghuanet._01login.domain.User;

public interface IUserService {
	/**
	 * 根据账号和密码一起查返回结果
	 */
	public boolean loginByUser(User u);
	/**
	 * 先根据账号 然后在判断密码
	 */
	public boolean loginByUserName(User u);
	
	public boolean loginByPst(User u);
	
}
