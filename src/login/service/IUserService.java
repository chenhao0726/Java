package login.service;

import login.domain.User;

public interface IUserService {

    /**
     * 根据账号和密码查询返回结果
     * @param user
     * @return
     */
    boolean loginByUser(User user);

    boolean loginByName(User user);

    boolean loginByPst(User user);

}
