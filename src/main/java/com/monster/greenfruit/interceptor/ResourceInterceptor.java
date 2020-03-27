package com.monster.greenfruit.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.WeakHashMap;

public class ResourceInterceptor implements HandlerInterceptor {


    private Logger access = LoggerFactory.getLogger("access");

    private WeakHashMap<String, String> para = new WeakHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Enumeration enu = request.getParameterNames();

        while (enu.hasMoreElements()) {

            String paraName = (String) enu.nextElement();

            para.put(paraName, request.getParameter(paraName));

        }

        access.info("请求路径为 : {} ---- 参数为 : {}", request.getServletPath(), para);

        para.clear();

        return true;
    }
}
