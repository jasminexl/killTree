package dongxin.flowbilling.channel.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dongxin.flowbilling.channel.entity.ChannelUserLogin;
import dongxin.flowbilling.channel.entity.byjChannel;
import dongxin.flowbilling.channel.service.UserService;
import dongxin.flowbilling.channel.service.byjChannelService;
import dongxin.flowbilling.channel.util.BaseController;
import dongxin.flowbilling.channel.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 渠道商备用金Controller
 *
 * @author yusongyuan
 * @create 2017-12-05 20:31
 **/
@Controller
@RequestMapping("/ChannelInfo")
public class byjChannelController extends BaseController {

    @Resource
    private byjChannelService service;
    @Resource
    private UserService userService;

    @RequestMapping("/selectByChcode.do")
    public void selectByChcode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        setResponse(response);
        String username = request.getParameter("chcode");
        byjChannel info = service.selectByChcode(username);
        if(info!=null){
            //记录日志
            userService.channelLog((ChannelUserLogin) request.getSession().getAttribute("user"), Util.getIpAddr(request), "查询余额");
            Gson gson = new GsonBuilder().create();
            doPrint(gson.toJson(info));
        }else{
            doPrint("1");
        }
    }

}
