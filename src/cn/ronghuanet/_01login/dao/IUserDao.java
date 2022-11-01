package cn.ronghuanet._01login.dao;

import cn.ronghuanet._01login.domain.User;

public interface IUserDao {
	/**
	 *  方式一: web输入的是账号和密码
	 *  	直接使用账号和密码到数据库查询 双匹配
	 *  	查询user对象 如果user == null 说明错误
	 *  	如果 user != null 成功
	 */
	User getUserByNameAndPwd(User u);
	/**
	 * 方式二: web输入的是账号和密码
	 * 		首先使用 账号去查询 如果查到user 在使用user.password 和用户输入密码比较
	 * 		 如果查不到user 直接失败
	 */
	User getUserByName(User u);
	
	/**
	 * 使用预编译对象
	 * @param u
	 * @return
	 */
	User getUserByPst(User u);
}
