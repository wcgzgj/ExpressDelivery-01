package top.faroz.view;

import top.faroz.pojo.Package;
import top.faroz.service.PackageService;
import top.faroz.service.impl.PackageServiceImpl;

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

    private static PackageService packageService = new PackageServiceImpl();

    /**
     * 类似于 vue 中的 template
     */
    public static void print() {
        System.out.println("\n\n");
        System.out.println("------  请输入要修改的快递的单号  ------");
        System.out.println("------  或输入 exit 退出       ------");
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
                 * 根据单号，修改快递信息
                 */
                System.out.println("请输入 新的\"快递单号\" 和新的 \"快递公司\" 信息");
                String newId = sc.next();
                String newBusiness = sc.next();
                /**
                 * 生成新的 package
                 */
                Package newPackage = new Package(daoPackage.getLocation(), newId, newBusiness, daoPackage.getGetCode());
                packageService.update(newPackage);
                System.out.println("更新成功");
                System.out.println("新的快递信息为:"+newPackage.toString());
                return "success";
            }
        }

    }
}
