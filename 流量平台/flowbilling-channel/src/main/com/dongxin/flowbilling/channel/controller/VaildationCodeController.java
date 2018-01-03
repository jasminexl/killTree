package dongxin.flowbilling.channel.controller;


import dongxin.flowbilling.channel.util.Base64;
import dongxin.flowbilling.channel.util.BaseController;
import dongxin.flowbilling.channel.util.MD5;
import dongxin.flowbilling.channel.util.ValidationCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 图片效验码
 *
 * @author yusongyuan
 * @create 2017-12-06 9:16
 **/
@Controller
@RequestMapping("/vail")
public class VaildationCodeController  extends BaseController {

    public static String verifyCode = "";

    @RequestMapping("/autoImg.do")
    public void autoImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        verifyCode = ValidationCode.generateVerifyCode(4);
        //生成图片
        int w = 100, h = 40;
        ValidationCode.outputImage(w, h, response.getOutputStream(), verifyCode);

        //将验证码<时间，验证码>放入session
        String date = request.getParameter("date");
        HttpSession session = request.getSession();
        session.removeAttribute(date);
        //对验证码base64加密之后再md5加密
        String verifycode = MD5.string2MD5(new String(Base64.encode(verifyCode.toLowerCase().getBytes())));
        System.out.println("------------------------date:"+date+"verifycode"+verifycode);
        session.setAttribute(date,verifycode);
    }

}
