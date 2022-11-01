package login.dao;

import login.domain.User;

public interface IUserDao {

    // 密码和账号同时查询
    User selectByNamePwd(User user);
    // 只查询账号对对应的密码
    User selectByName(User user);

    User getUserByPst(User user);
}
