package com.logonovo.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by logonovo on 2017/3/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper UserMapper;

    @Test
    public void testInsert() throws Exception {
        UserEntity user = new UserEntity();
        user.setName("宁宁");
        user.setCreatDate(new Date());
        user.setEmail("a@b.c");
        user.setDes("my son");
        user.setPhone("1898888888");
        user.setPwd("123456");
        user.setStatus("S0A");
        UserMapper.insert(user);

        Assert.assertEquals(1, UserMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<UserEntity> users = UserMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        UserEntity user = UserMapper.getOne(3l);
        System.out.println(user.toString());
        user.setName("neo");
        UserMapper.update(user);
        Assert.assertTrue(("neo".equals(UserMapper.getOne(3l).getName())));
    }
}
