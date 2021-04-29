package top.faroz.view;

import top.faroz.pojo.Package;
import top.faroz.service.PackageService;
import top.faroz.service.impl.PackageServiceImpl;

import java.util.Scanner;

/**
 * @ClassName DeleteView
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/29 上午8:46
 * @Version 1.0
 **/
public class DeleteView {
    private static Scanner sc = new Scanner(System.in);

    private static PackageService packageService = new PackageServiceImpl();

    /**
     * 类似于 vue 中的 template
     */
    public static void print() {
        System.out.println("\n\n");
        System.out.println("------  请输入要删除的快递单号  ------");
        System.out.println("------  或输入 exit 退出      ------");
    }

    /**
     * 类似于 vue 中的 js
     */
    public static String getInput() {
        while (true) {
            SearchView.print();
            print();
            String input = sc.next();
            if (input.equals("exit")) {
                return "exit";
            } else {
                /**
                 * 查询有无该单号
                 */
                Package daoPackage = packageService.selectById(input);
                if (daoPackage==null) {
                    System.out.println("不存在该包裹");
                    return "fail";
                }

                /**
                 * 根据单号，删除快递信息
                 */
                Package deletedDaoPackage = packageService.deleteById(input);
                System.out.println("删除成功，删除的包裹信息为:");
                System.out.println(deletedDaoPackage.toString());
                return "success";
            }
        }
    }



}
