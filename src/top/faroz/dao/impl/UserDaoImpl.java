package top.faroz.dao.impl;

import top.faroz.dao.UserDao;
import top.faroz.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserDaoimpl
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/28 下午8:21
 * @Version 1.0
 **/
public class UserDaoImpl implements UserDao {
    /**
     * 模拟数据库，保存管理员信息
     */
    private static Map<String, String> admins = new HashMap<>();
    static {
        admins.put("admin","123");
        admins.put("admin2","123");
    }

    /**
     * 根据姓名，查询"数据库"中的用户信息
     * @param name
     * @return
     */
    @Override
    public User selectByName(String name) {
        String password = admins.get(name);
        //初始化密码为空串，不然会出现空指针异常
        if (password==null) {
            password="";
        }
        return new User(name,password);
    }
}
