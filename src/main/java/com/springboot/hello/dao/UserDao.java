package com.springboot.hello.dao;

import com.springboot.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class UserDao {

    private DataSource dataSource;
    private JdbcTemplate jebcTemplete;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jebcTemplete = jdbcTemplate;
    }

    public void add(User user) {
        this.jebcTemplete.update("insert into users(id, name, password) values (?,?,?)",
                user.getId(), user.getName(), user.getPassword());
    }

    public int deleteAll() {
        return this.jebcTemplete.update("delete from users");
    }

    public User findById(String id) throws SQLException {
        Map<String, String> env = System.getenv();
        Connection c;
        c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE  id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        User user = null;
        if(rs.next()) {
            user = new User(rs.getString("id"), rs.getString("name"),
                    rs.getString("password"));
        }

        rs.close();
        ps.close();
        c.close();

        if (user==null) throw new RuntimeException();

        return user;
    }

}

