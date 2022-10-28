package com.springboot.hello.dao;

import com.springboot.hello.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Component //컴포넌트 스캔기능으로 빈을 자동으로 스프링컨테이너에 등록함
public class UserDao {

    private final JdbcTemplate jdbcTemplate;
    //private final로 JdbcTmplate을 선언하거나 @Autowired를 이용해 선언하면 프로그램이 실행될때 자동으로 환경변수에서 값을 가져옴.

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addUser(final User user) { //추가 혹은 삭제가 잘되었는지 확인하기위해 리턴값을 받음
        return this.jdbcTemplate.update("insert into users(id, name, password) values (?,?,?)",
                user.getId(), user.getName(), user.getPassword());
    }

    public int deleteAll() {

        return this.jdbcTemplate.update("delete from users");
    }

    public int deleteUser(String id) {
        return this.jdbcTemplate.update("delete from users where id = ?", id);
    }
}


