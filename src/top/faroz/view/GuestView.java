package top.faroz.view;

import top.faroz.pojo.Package;
import top.faroz.service.PackageService;
import top.faroz.service.impl.PackageServiceImpl;

import java.util.Scanner;

/**
 * @ClassName GuestView
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/28 下午10:43
 * @Version 1.0
 **/
public class GuestView {

    private static Scanner sc = new Scanner(System.in);

    //packageService 服务层接口
    private static PackageService packageService = new PackageServiceImpl();

    public static void print() {
        System.out.println("\n\n");
        System.out.println("------  欢迎 Guest              ------");
        System.out.println("------  1.输入6位单号取件         ------");
        System.out.println("------  2.输入 exit 回到主界面    ------");
    }

    public static String getInput() {
        while (true) {
            String input = sc.next();
            if (input.equals("exit")) {
                return "exit";
            }

            int code=-1;
            try {
                code = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("\n\n输入错误，请输入 6 位数字或者 exit");
                continue;
            }

            Package pack = packageService.getByCode(code);
            if (pack==null) {
                System.out.println("\n\n错误，没有查询到该包裹");
                System.out.println("请重新输入,或输入 exit 退出");
            } else {
                Package gotPackage = packageService.deleteByCode(code);
                System.out.println("\n\n包裹领取成功");
                System.out.println("包裹信息为:"+gotPackage.toString());
                return "success";
            }
        }
    }
}
