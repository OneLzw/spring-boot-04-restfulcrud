package com.easydev.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器中加入我们自己定义的 getErrorAttributes
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    //返回的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company" , "easydev");
        //我们的异常携带的数据
        Map<String , Object> mymap = (Map<String, Object>) webRequest.getAttribute("exc", 0);
        map.put("exc", mymap);
        return map;
    }
}
