package dongxin.flowbilling.channel.mapper;


import dongxin.flowbilling.channel.entity.ChannelUserLogin;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    ChannelUserLogin selectUserByUserName(String username);

    List<ChannelUserLogin> selectUserByPwd(Map<String, String> map);

    void channelLog(Map<String, String> map);

    void changePWD(Map<String, String> map);
}
