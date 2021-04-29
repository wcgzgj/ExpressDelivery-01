package top.faroz.view;

import java.util.Scanner;

/**
 * @ClassName UpdateView
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/29 上午8:46
 * @Version 1.0
 **/
public class UpdateView {
    private static Scanner sc = new Scanner(System.in);


    /**
     * 类似于 vue 中的 template
     */
    public static void print() {
        System.out.println("\n\n");
        System.out.println("------欢迎使用快递管理系统------");
        System.out.println("------    请选择用户    ------");
        System.out.println("1. admin");
        System.out.println("2. 一般用户");
        System.out.println("3. 退出系统");
    }

    /**
     * 类似于 vue 中的 js
     */
    public static String getInput() {
        while (true) {
            String input = sc.next();
            switch (input) {
                case "1":
                    LoginView.print();
                    String url = LoginView.getInput();
                    if (url.equals("home")) {
                        print();
                        break;
                    } else if (url.equals("success")){
                        AdminView.print();
                        AdminView.getInput();
                        print();
                    } else {
                        System.out.println("\n\n 登录失败，退回首页");
                        print();
                        break;
                    }
                    break;
                case "2":
                    GuestView.print();
                    GuestView.getInput();
                    print();
                    break;
                case "3":
                    return null;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }

    }
}
