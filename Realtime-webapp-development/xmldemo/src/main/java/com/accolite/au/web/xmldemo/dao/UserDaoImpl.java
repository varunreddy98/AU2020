package com.accolite.au.web.xmldemo.dao;

import com.accolite.au.web.xmldemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    List<User> users;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User getUser(@RequestParam String tel)
    {
        //return users.stream().filter(user->user.getName().equals(name)).findFirst().get();
        return jdbcTemplate.queryForObject("select * from user where tel="+tel,User.class);


    }


    @Override
    public User setandGetUserservice(User user)
    {
        return user;
    }

    @Override
    public void addUserService(User user) {

        jdbcTemplate.update("insert into user values(?,?,?,?)",user.getTel(),user.getFirstname(),user.getLastname(),user.getAge());


    }

    public void getUserService(User user){

    }

    @Override
    @PostConstruct
    public void setUp()
    {
//        users=new ArrayList<User>();
//        User u=new User();
//        u.setAge(21);
//        u.setName("varun reddy");
//        u.setId(1);
//        users.add(u);
//        User u1=new User();
//        u1.setAge(30);
//        u1.setId(2);
//        u1.setName("test");
//        users.add(u1);
    }

      @Override
     public List<User> getAll()
    {
        return jdbcTemplate.query("select * from user",new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rownumber) throws SQLException {
                User u=new User();
                u.setTel(rs.getString(1));
                u.setFirstname(rs.getString(2));
                u.setLastname(rs.getString(3));
                u.setAge(rs.getInt(4));
                return u;
            }
        });
    }

    @Override
    public void deleteUser(String tel)
    {
        jdbcTemplate.update("delete  from user where tel=?",tel);
    }
}
