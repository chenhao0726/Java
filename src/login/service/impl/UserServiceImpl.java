package login.service.impl;

import login.dao.IUserDao;
import login.dao.impl.IUserDaoImpl;
import login.domain.User;
import login.service.IUserService;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new IUserDaoImpl();

    @Override
    public boolean loginByUser(User user) {
        User user1 = userDao.selectByNamePwd(user);
        return user1 == null?false:true;
    }

    @Override
    public boolean loginByName(User user) {
        User user1 = userDao.selectByName(user);
        if (user1 == null) {
            System.out.println("账号不存在");
            return false;
        }
        if (user1.getPassword().equals(user.getPassword())) {
            return true;
        }
        System.out.println("密码错误");
        return false;
    }

    @Override
    public boolean loginByPst(User user) {
        User userByPst = userDao.getUserByPst(user);
        return userByPst == null?false:true;
    }
}
