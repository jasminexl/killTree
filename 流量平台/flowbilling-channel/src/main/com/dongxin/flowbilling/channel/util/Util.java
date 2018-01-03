package dongxin.flowbilling.channel.util;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dongxin.flowbilling.channel.entity.ChannelUserLogin;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 工具类
 *
 * @author yusongyuan
 * @create 2017-12-05 21:09
 **/

public class Util<T> {

    /**
     * 将泛型的class转为map
     * @param t
     * @return
     */
    public Map<String, Object> classToMap(T t){
        Map<String, Object> map = new HashMap<String, Object>();
        //将属性存为列表
        Field[] field = t.getClass().getDeclaredFields();
        for (Field f:field) {
            f.setAccessible(true);
            try{
                //将泛型中的属性名称和属性值放入到map中
                map.put(f.getName(),f.get(t));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 获取请求客户端的ip地址
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    @Test
    public void testClassToMap(){
        Util util = new Util();
        Map<String, Object> map = util.classToMap(new ChannelUserLogin());
        System.out.println(map);

        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(new ChannelUserLogin()));
    }

}
