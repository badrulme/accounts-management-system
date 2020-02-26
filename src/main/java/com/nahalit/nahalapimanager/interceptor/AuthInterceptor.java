package com.nahalit.nahalapimanager.interceptor;

import com.nahalit.nahalapimanager.apiconfig.AppConfig;
import com.nahalit.nahalapimanager.constant.KEY;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;

@Component(value = "coreAuthInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(response.SC_OK);
            return true;
        } else {
            try {
                final Claims claims = Jwts.parser().setSigningKey(AppConfig.APPLICATION_JWT_PRIVATE_KEY).parseClaimsJws(request.getHeader(KEY.TOKEN)).getBody();
                request.setAttribute(KEY.SESSION_COMPANY_NO, Long.parseLong(claims.getAudience()));
                request.setAttribute(KEY.SESSION_USER_NO, Long.parseLong(claims.getIssuer()));
                request.setAttribute(KEY.SESSION_EMP_NO, Long.parseLong(claims.getIssuer()));
                request.setAttribute(KEY.SESSION_NO, claims.getId());
                return true;
            } catch (SignatureException ex) {
                logger.error("Invalid JWT signature");
            } catch (MalformedJwtException ex) {
                logger.error("Invalid JWT token");
            } catch (ExpiredJwtException ex) {
                logger.error("Expired JWT token");
            } catch (UnsupportedJwtException ex) {
                logger.error("Unsupported JWT token");
            } catch (IllegalArgumentException ex) {
                logger.error("JWT claims string is empty.");
            }
            response.setStatus(response.SC_UNAUTHORIZED);
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//        System.out.println("this is interceptor, postHandle method");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("this is interceptor, afterCompletion method");
    }

}

