package dongxin.flowbilling.channel.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 将HttpResponse的write工具类
 *
 * @author yusongyuan
 * @create 2017-12-05 20:43
 **/

public class BaseController {

    private HttpServletResponse response;


    /**
     * 对浏览器的请求返回字符串
     * @param obj 要输出的字符串
     * @throws IOException
     */
    public String doPrint(Object obj)	{
        this.getResponse().setContentType("text/html;charset=utf-8");
        PrintWriter pw;
        try {
            pw = this.getResponse().getWriter();
            pw.print(obj.toString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }


}
