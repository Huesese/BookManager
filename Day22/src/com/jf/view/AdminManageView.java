package com.jf.view;

import com.jf.controller.AdminController;

import java.util.Scanner;

public class AdminManageView {
    public static void show() {
        Scanner sc = new Scanner(System.in);

        AdminController adminController = new AdminController();
        System.out.println("------------------小蜜蜂书籍管理------------------");
        System.out.println("1.登录     2.查看管理员     3.添加管理员    4.退出系统");
        System.out.println("请输入要操作的功能序号[ 1 - 4 ]: ");

        String num = sc.next();

        switch(num) {
            case "1":
                adminController.login();
                break;
            case "2":
                adminController.show();
                break;
            case "3":
                adminController.register();
                break;
            case "4":
                System.out.println("退出成功!");
                System.exit(0);
            default:
                System.out.println("输入错误，请重新输入!");
                break;
        }

    }
}
