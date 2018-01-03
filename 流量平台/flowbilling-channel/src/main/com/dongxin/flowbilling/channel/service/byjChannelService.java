package dongxin.flowbilling.channel.service;

import dongxin.flowbilling.channel.entity.byjChannel;
import dongxin.flowbilling.channel.mapper.byjChannelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 渠道商备用金ServiceImpl
 *
 * @author yusongyuan
 * @create 2017-12-05 20:27
 **/
@Service
public class byjChannelService {

    @Resource
    private byjChannelMapper byjChannelMapper;

    /**
     * 获取chcode对应的渠道商信息
     * @param chcode
     * @return
     */
    public byjChannel selectByChcode(String chcode) {
        //获取当前时间的年份最后两个字段，月份，拼接作为需要联查的当月表
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date =  sdf.format( new Date());
        String historyTable = "byjchannelinfolog"+date.substring(2,4)+date.substring(5,7);
        Map<String, String> map = new HashMap<String, String>();
        map.put("chcode",chcode);
        map.put("historyTable",historyTable);
        return byjChannelMapper.selectByChcode(map);
    }
}
