package top.faroz.session;

import top.faroz.exception.LoginedException;
import top.faroz.pojo.User;

/**
 * @ClassName Session
 * @Description 在前后端分离中，将用户的登录数据存储在 session 中
 * 但是这个模拟程序没有 session，我就只能自己写一个 session 了
 * @Author FARO_Z
 * @Date 2021/4/28 下午8:39
 * @Version 1.0
 **/
public class Session {
    //session 只存储一个用户信息
    private static User currentUser;

    public static void setCurrentUser(User user) throws LoginedException {
        if (currentUser!=null) {
            throw new LoginedException();
        }
        currentUser=user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void deleteCurrentUser() {
        currentUser=null;
    }


}
