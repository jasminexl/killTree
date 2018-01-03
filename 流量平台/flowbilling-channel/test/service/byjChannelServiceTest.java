package service;

import dongxin.flowbilling.channel.entity.byjChannel;
import dongxin.flowbilling.channel.service.byjChannelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 渠道商备用金实体类dao测试
 *
 * @author yusongyuan
 * @create 2017-12-05 20:21
 **/
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application*.xml"})
public class byjChannelServiceTest {

    @Autowired
    byjChannelService service;

    @Test
    public void testSelectByChcode(){
        byjChannel b = service.selectByChcode("ronglian");
        System.out.println(b);
    }

}
