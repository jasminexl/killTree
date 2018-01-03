package dongxin.flowbilling.channel.mapper;


import dongxin.flowbilling.channel.entity.RunLogChannelInfo;

public interface RunLogChannelInfoMapper {

    RunLogChannelInfo selectByChcode(String chcode);

}
