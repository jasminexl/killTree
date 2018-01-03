package mapper;

import dongxin.flowbilling.channel.entity.byjChannel;
import dongxin.flowbilling.channel.mapper.byjChannelMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 渠道商备用金实体类dao测试
 *
 * @author yusongyuan
 * @create 2017-12-05 20:21
 **/
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application*.xml"})
public class byjChannelDaoTest {

    @Autowired
    public byjChannelMapper byjChannelMapper;

    @Test
    public void testSelectByChcode(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("chcode","ronglian");
        map.put("historyTable","byjchannelinfolog1712");
        byjChannel byjChannel = byjChannelMapper.selectByChcode(map);
        System.out.println(byjChannel);
    }

}
