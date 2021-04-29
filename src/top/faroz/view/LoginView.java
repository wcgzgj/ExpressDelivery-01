package top.faroz.view;

import top.faroz.exception.LoginFailException;
import top.faroz.exception.WrongInputException;
import top.faroz.pojo.User;
import top.faroz.service.UserService;
import top.faroz.service.impl.UserServiceImpl;

import java.util.Scanner;

/**
 * @ClassName LoginView
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/28 下午10:55
 * @Version 1.0
 **/
public class LoginView {
    private static Scanner sc = new Scanner(System.in);

    private static UserService userService = new UserServiceImpl();

    private static boolean loginSuccess=false;


    public static void print() {
        System.out.println("\n\n");
        System.out.println("------   登录界面                ------");
        System.out.println("------   请输入用户名和密码        ------");
        System.out.println("------   或输入 exit 回到主界面    ------");
    }

    public static String getInput() {
        while (true) {
            String name = sc.next();
            if (name.equals("exit")) {
                return "home";
            }
            String password = sc.next();
            User loginUser = new User(name, password);
            if (!userService.login(loginUser)) {
                return "fail";
            }
            return "success";
        }

    }
}
