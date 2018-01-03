package service;

import dongxin.flowbilling.channel.entity.ChannelUserLogin;
import dongxin.flowbilling.channel.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户dao测试
 *
 * @author yusongyuan
 * @create 2017-12-05 18:41
 **/

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class UserDaoTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser() throws Exception{
        ChannelUserLogin user =  userMapper.selectUserByUserName("testceshi");
        System.out.println(user);
    }

    @Test
    public void testSelectUserBy() throws Exception{
        Map<String, String> map = new HashMap<String, String>();
        map.put("pwd", "e10adc3949ba59abbe56e057f20f883e");
        List<ChannelUserLogin> list =  userMapper.selectUserByPwd(map);
        for (ChannelUserLogin u:list) {
            System.out.println(u);
        }

    }

}
