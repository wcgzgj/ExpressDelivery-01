package top.faroz.service.impl;

import top.faroz.dao.UserDao;
import top.faroz.dao.impl.UserDaoImpl;
import top.faroz.exception.LoginedException;
import top.faroz.pojo.User;
import top.faroz.service.UserService;
import top.faroz.session.Session;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/28 下午8:20
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {

    //Dao 层接口
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean login(User user) {
        User daoUser = userDao.selectByName(user.getName());
        /**
         * 若根据名字查不出来
         */
        if (daoUser==null) {
            return false;
        }

        /**
         * 或者输入的密码和对应用户的密码不匹配
         */
        if (!daoUser.getPassword().equals(user.getPassword())) {
            return false;
        }

        //登录成功，将用户存进 session 中
        try {
            Session.setCurrentUser(daoUser);
        } catch (LoginedException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
