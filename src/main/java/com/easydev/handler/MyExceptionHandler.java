package com.easydev.handler;

import com.easydev.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //1、浏览器和客户端返回的都是json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String , Object> handlerException (Exception e) {
//        Map<String , Object> map = new HashMap<>();
//        map.put("code" , "user.notexist");
//        map.put("msg" , e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException (Exception e , HttpServletRequest request) {
        Map<String , Object> map = new HashMap<>();
        //传入我们自己的错误状态码 4xx 5xx之类的
        /*
         * Integer statusCode =
         * (Integer)request.getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code" , 500);
        map.put("code" , "user.notexist");
        map.put("msg" , e.getMessage());
        request.setAttribute("exc" , map);
        //转发到 /error ,由BasicErrorController处理
        return "forward:/error";
    }
}
