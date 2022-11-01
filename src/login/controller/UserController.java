package login.controller;

import login.domain.User;
import login.service.IUserService;
import login.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserController {
    private IUserService userService = new UserServiceImpl();

    @Test
    public void testByUser(){
        boolean loginByUser = userService.loginByUser(new User("Tom", "123456"));
        System.out.println(loginByUser?"成功":"失败");
    }

    @Test
    public void testLoginByName() {
        boolean tom = userService.loginByName(new User("Tom", "123456"));
        System.out.println(tom?"成功":"失败");
    }

    @Test
    public void testLoginByPst() {
        boolean tom = userService.loginByPst(new User("Tom", "123456"));
        System.out.println(tom?"成功":"失败");
    }

}
