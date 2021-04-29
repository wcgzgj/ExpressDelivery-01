package top.faroz.dao;

import sun.security.jca.GetInstance;
import top.faroz.pojo.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/28 下午8:15
 * @Version 1.0
 **/
public interface UserDao {
    User selectByName(String name);
}
