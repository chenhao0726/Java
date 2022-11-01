package cn.ronghuanet._01login.service.impl;

import cn.ronghuanet._01login.dao.IUserDao;
import cn.ronghuanet._01login.dao.impl.UserDaoImpl;
import cn.ronghuanet._01login.domain.User;
import cn.ronghuanet._01login.service.IUserService;

public class UserServiceImpl implements IUserService{
	private IUserDao dao = new UserDaoImpl();
	@Override
	public boolean loginByUser(User u) {
		User user = dao.getUserByNameAndPwd(u);
		return user == null ? false : true;
	}

	@Override
	public boolean loginByUserName(User u) {
		User user = dao.getUserByName(u);
		if(user == null) {
			System.out.println("账号不存在");
			return false;
		}
		if(user.getPassword().equals(u.getPassword())) {
			return true;
		}
		System.out.println("密码错误");
		return false;
	}

	@Override
	public boolean loginByPst(User u) {
		
		return dao.getUserByPst(u) == null?false:true;
	}

}
