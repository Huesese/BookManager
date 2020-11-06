package com.jf.dao;

import com.jf.model.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;
import java.util.UUID;

public class BookDao {
    /**
     * 查看全部
     * @return
     */
    public static List<Book> bookList() {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM book";
        return jt.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    /**
     * 以价格为条件查询
     * @param price1
     * @param price2
     * @return
     */
    public static List<Book> bookListByPrice(int price1, int price2) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM book WHERE price > ? AND price < ?";
        if (price1 <= price2) {
            return jt.query(sql, new BeanPropertyRowMapper<>(Book.class), price1, price2);
        } else {
            return jt.query(sql, new BeanPropertyRowMapper<>(Book.class), price2, price1);
        }
    }

    /**
     * 编辑书籍
     * @param book
     *          修改信息封装
     * @param bookFormerName
     * @return
     */
    public static int bookEdit(Book book, String bookFormerName) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "UPDATE book SET name = ?, autho = ?, price = ? WHERE name = ?";
        return jt.update(sql, book.getName(), book.getAutho(), book.getPrice(), bookFormerName);
    }

    /**
     * 添加书籍
     * @param book
     * @return
     */
    public static int bookAdd(Book book) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "INSERT INTO book VALUES(?,?,?,?)";
        return jt.update(sql, UUID.randomUUID().toString(), book.getName(), book.getAutho(), book.getPrice());
    }

    /**
     * 删除书籍
     * @param bookFormerName
     * @return
     */
    public static int bookDelete(String bookFormerName) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "DELETE FROM book WHERE name = ?";
        return jt.update(sql, bookFormerName);
    }

    /**
     * 模糊查询
     * @param ch
     * @return
     *      list
     */
    public static List<Book> bookListByCharacter(String ch) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM book WHERE name LIKE ? or autho LIKE ?";
        return jt.query(sql, new BeanPropertyRowMapper<>(Book.class), "%" + ch + "%", "%" + ch + "%");
    }
}
