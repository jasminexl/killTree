package dongxin.flowbilling.channel.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dongxin.flowbilling.channel.entity.RunLogChannelInfo;
import dongxin.flowbilling.channel.service.RunLogChannelInfoService;
import dongxin.flowbilling.channel.util.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 渠道商备用金Controller
 *
 * @author yusongyuan
 * @create 2017-12-05 20:31
 **/
@Controller
@RequestMapping("/ChannelInfo")
public class RunLogChannelInfoController extends BaseController {

    @Resource
    private RunLogChannelInfoService service;

    @RequestMapping("/selectByChcode.do")
    public void selectByChcode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        setResponse(response);
        RunLogChannelInfo info = service.selectByChcode(request.getParameter("chcode"));
        if(info!=null){
            Gson gson = new GsonBuilder().create();
            doPrint(gson.toJson(info));
        }else{
            doPrint("1");
        }
    }

}
