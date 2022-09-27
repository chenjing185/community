package com.nowcoder.community;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author 陈靖
 * @date 2022/9/24
 * @describe
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser(){
        System.out.println("第一次查询");
        User id = userMapper.selectById(101);
        System.out.println(id.getUsername());
        System.out.println("第二次查询");
        User name = userMapper.selectByName("liubei");
        System.out.println(name);
        System.out.println("第三次查询");
        User email = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(email);
    }
    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "hello");
        System.out.println(rows);
    }
}
