package com.jf.view;

import com.jf.controller.BookController;

import java.util.Scanner;

public class BookManageView {
    public static void show() {
        Scanner sc = new Scanner(System.in);
        String num = null;
        System.out.println("----------------------小蜜蜂书籍管理----------------------");
        System.out.println("1.添加书籍 2.编辑书籍 3.删除书籍 4.查询书籍 5.退出系统 6.退出登录");
        num = sc.next();
        switch (num) {
            case "1":
                BookController.addBook();
                break;
            case "2":
                BookController.editBook();
                break;
            case "3":
                BookController.deleteBook();
                break;
            case "4":
                BookController.show();
                break;
            case "5":
                System.out.println("系统退出成功");
                System.exit(0);
            case "6":
                Main.isLogin = false;
                break;
            default:
                System.out.println("输入有误!");
                break;
        }
    }
}
