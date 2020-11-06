package com.jf.controller;

import com.jf.dao.AdminDao;
import com.jf.model.Admin;
import com.jf.view.Main;
import utils.MD5Utils;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    /**
     * 登录
     */
    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.next();
        System.out.println("请输入密码:");
        String password = sc.next();
        password = MD5Utils.stringToMD5(password);
        List<Admin> list = AdminDao.getAdminByUsernameAndPassword(name, password);
        if (list == null || list.size() ==0) {
            System.out.println("登录失败, 用户名或密码有误!");
        } else {
            Main.isLogin = true;
            System.out.println("登录成功!");
        }
    }

    /**
     * 查看管理员信息
     */
    public void show() {
        List<Admin> list = AdminDao.show();
        for (Admin admin : list) {
            System.out.println("username: " + "\t" + admin.getName() + "\tpassword: " + "\t******");
        }
    }

    /**
     * 注册用户
     */
    public void register() {
        Scanner sc = new Scanner(System.in);
        List<Admin> list = AdminDao.show();
        System.out.println("请输入用户名:");
        String name = null;
        name = sc.next();
        for (Admin admin : list) {
            if (name.equals(admin.getName())) {
                System.out.println("用户名已存在!");
                return;
            }
        }
        System.out.println("请输入密码:");
        String password = sc.next();
        password = MD5Utils.stringToMD5(password);
        int i = AdminDao.register(name, password);
        if (i == 1) {
            System.out.println("注册成功!");
        } else {
            System.out.println("注册失败!");
        }
    }
}
