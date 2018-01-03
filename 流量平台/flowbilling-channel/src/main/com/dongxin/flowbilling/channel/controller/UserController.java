package dongxin.flowbilling.channel.controller;

import dongxin.flowbilling.channel.entity.ChannelUserLogin;
import dongxin.flowbilling.channel.service.UserService;
import dongxin.flowbilling.channel.util.BaseController;
import dongxin.flowbilling.channel.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户controller
 *
 * @author yusongyuan
 * @create 2017-12-05 18:15
 **/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/showUser.do",method = RequestMethod.POST)
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        ChannelUserLogin user = this.userService.selectUser(username);
        doPrint(user);
    }

    @RequestMapping(value = "/test.do",method = RequestMethod.GET)
    public @ResponseBody
    String test(){
        return "123";
    }

    /**
     * 登陆
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setResponse(response);
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String timestamp = request.getParameter("date");
        try{
            //将从页面接收的date时间戳作为key获取value，同传来的encode比较，都转为小写
            if(!session.getAttribute(timestamp).toString().toLowerCase().equals(request.getParameter("encode").toLowerCase())){
                doPrint("1");
            }
            ChannelUserLogin user = this.userService.login(request.getParameter("userno"),request.getParameter("pwd"));
            if (user != null){
                //用户状态不正常
                if (user.getStatus()==1){
                    doPrint("2");
                    //成功,返回字符串并将user放到session中
                }else if (user.getStatus()==0){
                    session.removeAttribute("user");
                    session.setAttribute("user",user);
                    //记录日志
                    userService.channelLog(user, Util.getIpAddr(request), "登陆");
                    doPrint("0");
                }
                //用户名或密码错误
            }else{
                doPrint("3");
            }
        //未知错误
        }catch (Exception e){
            e.printStackTrace();
            doPrint("4");
        }finally {
            //无论成功失败，都将验证码从session删除
            session.removeAttribute(timestamp);
        }
    }

    /**
     * 退出
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/exit.do",method = RequestMethod.POST)
    public void exit (HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        setResponse(response);
        HttpSession session = request.getSession();
        //记录日志
        userService.channelLog((ChannelUserLogin) session.getAttribute("user"), Util.getIpAddr(request), "退出");
        //不为空时删除该键值对
        if(session.getAttribute("user") != null){
            session.removeAttribute("user");
        }
        doPrint("0");
    }

    /**
     * 修改密码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/changePWD.do",method = RequestMethod.POST)
    public void changePWD (HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        setResponse(response);
        HttpSession session = request.getSession();

        try {
            ChannelUserLogin user = new ChannelUserLogin();
            user.setUsername(request.getParameter("userno"));
            user.setPassword(request.getParameter("pwd"));
            userService.changePWD(user);
            //重新获取该用户,并在session中重置
            user = this.userService.selectUser(request.getParameter("userno"));
            session.setAttribute("user", user);
            //记录日志
            userService.channelLog(user, Util.getIpAddr(request), "修改密码为："+request.getParameter("newPWD"));
            doPrint("0");
        }catch (Exception e){
            e.printStackTrace();
            doPrint("1");
        }
    }

}
