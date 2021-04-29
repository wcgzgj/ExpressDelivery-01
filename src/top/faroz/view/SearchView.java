package top.faroz.view;

import top.faroz.pojo.Package;
import top.faroz.service.PackageService;
import top.faroz.service.impl.PackageServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @ClassName SearchView
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/29 上午8:46
 * @Version 1.0
 **/
public class SearchView {
    private static Scanner sc = new Scanner(System.in);

    private static PackageService packageService = new PackageServiceImpl();

    /**
     * 类似于 vue 中的 template
     */
    public static void print() {
        System.out.println("\n\n");
        System.out.println("------    所有快递为    ------");
        List<Package> list = packageService.getAllPackage();
        for (Package aPackage : list) {
            System.out.println(aPackage+"\n\n");
        }
    }

    /**
     * 类似于 vue 中的 js
     */
    public static String getInput() {
        return "";
    }
}
