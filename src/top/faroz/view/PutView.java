package top.faroz.view;

import top.faroz.pojo.Package;
import top.faroz.service.PackageService;
import top.faroz.service.impl.PackageServiceImpl;
import top.faroz.util.IdUtil;

import java.util.Scanner;

/**
 * @ClassName InputView
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/29 上午8:45
 * @Version 1.0
 **/
public class PutView {
    private static Scanner sc = new Scanner(System.in);

    private static PackageService packageService = new PackageServiceImpl();


    /**
     * 类似于 vue 中的 template
     */
    public static void print() {
        System.out.println("\n\n");
        System.out.println("------   请输入 快递单号 和 快递公司  ------");
    }

    /**
     * 类似于 vue 中的 js
     */
    public static String getInput() {
        while (true) {
            print();
            /**
             * 系统获取空柜子位置
             */
            Integer location = packageService.getEmptyLocation();
            if (location.equals(-1)) {
                System.out.println("\n\n错误，柜子已满");
                return "fail";
            }

            /**
             * 快递单号
             */
            String id = sc.next();
            /**
             * 快递公司
             */
            String business = sc.next();

            /**
             * 系统生成不重复的 6 位取件码
             */
            Integer getCode = IdUtil.getUnsameSixGetCode();

            //public Package(Integer location, String id, String business, Integer getCode) {
            Package newPackage = new Package(location, id, business, getCode);

            boolean resp = packageService.putPackage(newPackage);
            if (!resp) {
                System.out.println("\n\n 录入错误");
                return "fail";
            } else {
                System.out.println("\n\n 存入成功，快递放在"+newPackage.getLocation()+"号柜子");
                return "success";
            }
        }

    }
}
