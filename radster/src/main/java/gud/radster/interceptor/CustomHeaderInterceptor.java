package gud.radster.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomHeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Add or check headers before the controller method is called
        return true; // Continue with the execution chain
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // Manipulate response after controller method has been executed
        System.out.println("CHeck!!!!!!!!!!");
//        response.addHeader("Access-Control-Allow-Origin","*");
////        response.addHeader("Access-Control-Allow-Origin" , "http://127.0.0.1:8080");
//        response.addHeader("Access-Control-Allow-Methods" ,"POST");
//        response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }
}