package com.jf.controller;

import com.jf.dao.BookDao;
import com.jf.model.Book;

import java.util.List;
import java.util.Scanner;

public class BookController {
    static Scanner sc = new Scanner(System.in);

    /**
     * 添加书籍
     */
    public static void addBook() {
        System.out.println("请输入书名: ");
        String bookName = sc.next();
        boolean exist = isExist(bookName);
        if (exist) {
            System.out.println("此书已存在!");
            return;
        }

        System.out.println("请输入作者: ");
        String author = sc.next();
        System.out.println("请输入价格: ");
        int price = sc.nextInt();

        int i = BookDao.bookAdd(packageInfo(bookName, author, price));
        if (i > 0) {
            System.out.println("书籍添加成功!");
        }
    }

    /**
     * 查询书籍
     */
    public static void show() {
        System.out.println("1. 查询所有\t\t2. 条件查询\t\t3. 模糊查询");
        String num = sc.next();
        if (num.equals("1")) {
            List<Book> list = BookDao.bookList();
            for (Book book : list) {
                System.out.println("书名 " + book.getName() + "\t作者 " + book.getAutho() + "\t价格 " + book.getPrice());
            }
        } else if (num.equals("2")) {
            System.out.println("请输入最低价格: ");
            int price1 = sc.nextInt();
            System.out.println("请输入最高价格: ");
            int price2 = sc.nextInt();
            List<Book> list = BookDao.bookListByPrice(price1, price2);
            for (Book book : list) {
                System.out.println("书名 " + book.getName() + "\t作者 " + book.getAutho() + "\t价格 " + book.getPrice());
            }
        } else if (num.equals("3")) {
            System.out.println("请输入关键字: ");
            String ch = sc.next();
            List<Book> list = BookDao.bookListByCharacter(ch);
            if (list == null || list.size() == 0) {
                System.out.println("未查到");
            } else {
                for (Book book : list) {
                    System.out.println("书名 " + book.getName() + "\t作者 " + book.getAutho() + "\t价格 " + book.getPrice());
                }
            }
        } else {
            System.out.println("输入有误!");
        }
    }

    /**
     * 编辑书籍
     */
    public static void editBook() {
        List<Book> list = BookDao.bookList();
        int index = 1;
        for (Book book : list) {
            System.out.println(index + "\t书名 " + book.getName() + "\t作者 " + book.getAutho() + "\t价格 " + book.getPrice());
            index++;
        }
//        int num = sc.nextInt();
//        Book book = list.get(num - 1);

        System.out.println("请输入需要修改的书名: ");
        String bookFormerName = sc.next();
        boolean exist = isExist(bookFormerName);
        if (!exist) {
            System.out.println("无此书!");
        }

        System.out.println("请输入修改的内容");
        System.out.println("书名: ");
        String bookName = sc.next();
        System.out.println("作者: ");
        String author = sc.next();
        System.out.println("价格: ");
        int price = sc.nextInt();

        int i = BookDao.bookEdit(packageInfo(bookName, author, price), bookFormerName);
        if (i != 0) {
            System.out.println("修改成功!");
        }
    }

    /**
     * 删除书籍
     */
    public static void deleteBook() {
        System.out.println("请输入需要删除的书名: ");
        String bookFormerName = sc.next();
        boolean exist = isExist(bookFormerName);
        if (!exist) {
            System.out.println("无此书!");
        }
        int i = BookDao.bookDelete(bookFormerName);
        if (i > 0) {
            System.out.println("删除成功!");
        }
    }

    /**
     * 判定是否存在
     * @param bookName
     * @return
     *      1: 存在
     *      0: 不存在
     */
    private static boolean isExist(String bookName) {
        List<Book> list = BookDao.bookList();
        for (Book book : list) {
            if (bookName.equals(book.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 封装书籍信息
     * @param bookName
     *          书名
     * @param author
     *          作者
     * @param price
     *          价格
     * @return
     */
    private static Book packageInfo(String bookName, String author, int price) {
        Book book = new Book();
        book.setName(bookName);
        book.setAutho(author);
        book.setPrice(price);
        return book;
    }

}
