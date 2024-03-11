package com.demo_bank_v1.interceptors;

import com.demo_bank_v1.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Component
public class AppInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       System.out.println("In pre handle interceptor");
       // TODO : CHECK REQUEST URI
        if (request.getRequestURI().startsWith("/app")){
            //GET SESSION
            HttpSession session = request.getSession();

            //TODO GET TOKEN STORED IN SESSION
            String token = (String) session.getAttribute("token");
            System.out.println(token);
            //TODO GET USER OBJECT STORED IN SESSION
            User user = (User) session.getAttribute("user");
            // TODO CHECK IF AUTHENTICATED
            //boolean isAuthenticated = (boolean) session.getAttribute("authenticated");

            // TODO VALIDATE SESSION ATTRIBUTES / OBJECTS
            if (token == null || user == null ) {
//                RedirectAttributes redirectAttributes;
//                String errorMessage = "You need to be logged in to access the page!";
//                redirectAttributes.addFlashAttribute("error", errorMessage);
                response.sendRedirect("/login");
                return false;
            }
            //End of validate session attributes / Objects
        }
        //End of check request URI
        return true;
    }
    //End of prehandle method


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("In post handle interceptor");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("In after handle interceptor");
    }
}
