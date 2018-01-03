package dongxin.flowbilling.channel.service;

import dongxin.flowbilling.channel.entity.ChannelUserLogin;
import dongxin.flowbilling.channel.mapper.UserMapper;
import dongxin.flowbilling.channel.util.MD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户service
 *
 * @author yusongyuan
 * @create 2017-12-05 18:08
 **/
@Service
public class UserService {

    @Resource
    private UserMapper usermapper;

    public ChannelUserLogin selectUser(String username){
        return this.usermapper.selectUserByUserName(username);
    }

    /**
     * 用户登陆
     * @param username
     * @param pwd
     * @return
     */
    public ChannelUserLogin login(String username, String pwd) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("pwd", pwd);
        List<ChannelUserLogin> list = this.usermapper.selectUserByPwd(map);
        for (ChannelUserLogin u:list) {
            if (MD5.string2MD5(u.getUsername()).equals(username)){
                return u;
            }
        }
        return null;
    }

    /**
     * 保存渠道操作日志
     * @param user
     * @param ip
     */
    public void channelLog(ChannelUserLogin user, String ip, String handle){
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", user.getUsername());
        map.put("channelName", user.getChname());
        map.put("logIP", ip);
        map.put("handle", handle);
        usermapper.channelLog(map);
    }

    /**
     * 修改密码
     * @param user
     */
    public void changePWD(ChannelUserLogin user){
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", user.getUsername());
        map.put("pwd", user.getPassword());
        usermapper.changePWD(map);
    }
}
