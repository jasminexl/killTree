package dongxin.flowbilling.channel.service;

import dongxin.flowbilling.channel.entity.RunLogChannelInfo;
import dongxin.flowbilling.channel.mapper.RunLogChannelInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 渠道商备用金ServiceImpl
 *
 * @author yusongyuan
 * @create 2017-12-05 20:27
 **/
@Service
public class RunLogChannelInfoService {

    @Resource
    private RunLogChannelInfoMapper runLogChannelInfoMapper;

    /**
     * 获取chcode对应的渠道商信息
     * @param chcode
     * @return
     */
    public RunLogChannelInfo selectByChcode(String chcode) {
        return runLogChannelInfoMapper.selectByChcode(chcode);
    }
}
