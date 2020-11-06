package com.jf.view;

public class Main {
    public static boolean isLogin = false;
    public static void main(String[] args) {
        while (true) {
            if (!isLogin) {
                AdminManageView.show();
            } else {
                BookManageView.show();
            }
        }
    }
}
