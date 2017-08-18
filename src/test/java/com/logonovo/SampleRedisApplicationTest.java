package com.logonovo;

import com.logonovo.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by logonovo on 2017/3/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SampleRedisApplicationTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisKeyValueTemplate redisKeyValueTemplate;
    @Test
    public void test() throws Exception {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        UserEntity user = new UserEntity();
        UserEntity u = redisKeyValueTemplate.findById(1,UserEntity.class);
        Assert.assertEquals("logo",u.getName());
    }
}
