package top.faroz.view;

import top.faroz.session.Session;

import java.util.Scanner;

/**
 * @ClassName AdminView
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/28 下午10:43
 * @Version 1.0
 **/
public class AdminView {

    private static Scanner sc = new Scanner(System.in);

    public static void print() {
        System.out.println("\n\n");
        System.out.println("------    欢迎"+ Session.getCurrentUser().getName()+"     ------");
        System.out.println("------    请选择操作     ------");
        System.out.println("1. 快递录入");
        System.out.println("2. 快递删除");
        System.out.println("3. 快递修改");
        System.out.println("4. 快递查询");
        System.out.println("5. 退回到主界面");
    }

    public static String getInput() {
        while (true) {
            print();
            String input = sc.next();
            switch (input) {
                case "1":
                    PutView.getInput();
                    break;
                case "2":
                    DeleteView.getInput();
                    break;
                case "3":
                    UpdateView.getInput();
                    break;
                case "4":
                    SearchView.print();
                    break;
                case "5":
                    /**
                     * 在退出 admin 账户的时候，
                     * 还要在 Session中删除登录信息
                     */
                    Session.deleteCurrentUser();
                    return null;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }


    }
}
