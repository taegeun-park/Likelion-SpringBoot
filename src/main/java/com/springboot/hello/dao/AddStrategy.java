package com.springboot.hello.dao;

import com.springboot.hello.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStrategy implements StatementStrategy {
    User user;

    @Override
    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareCall("insert into users(id,name,password) values (?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        return ps;
    }

}
