package com.monster.greenfruit.interceptor;

import com.monster.greenfruit.service.exception.SessionExpirationException;
import com.monster.greenfruit.pojo.domain.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionAuthenticationInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        try {
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            if (admin == null) {
                throw new SessionExpirationException("session已过期,请重新登陆");
            }
            return true;
        } catch (SessionExpirationException e) {
            response.sendRedirect("/greenfruit/admin/admin/page/login");
            return false;
        }
    }
}
