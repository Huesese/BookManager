package com.jf.dao;

import com.jf.model.Admin;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;
import java.util.UUID;

public class AdminDao {

    /**
     * 用户登录
     * @param name
     * @param password
     * @return
     *      1: 成功
     *      0: 失败
     */
    public static List<Admin> getAdminByUsernameAndPassword(String name, String password) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * from admin where name = ? AND password = ?";
        return jt.query(sql, new BeanPropertyRowMapper<>(Admin.class), name, password);
    }

    /**
     * 查看用户
     * @return
     *      list: 所有用户
     */
    public static List<Admin> show() {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * from admin";
        return jt.query(sql, new BeanPropertyRowMapper<>(Admin.class));
    }

    /**
     * 注册
     * @param name
     *          用户名
     * @param password
     *          密码
     * @return
     */
    public static int register(String name, String password) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "INSERT INTO admin VALUES(?,?,?)";
        return jt.update(sql, UUID.randomUUID().toString(), name, password);
    }
}
