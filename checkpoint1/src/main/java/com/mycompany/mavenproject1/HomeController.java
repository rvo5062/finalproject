/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ryanoneill
 */
@Controller
public class HomeController {
    
    
    @RequestMapping("/index")
    public String home() {
        return "index";
    }
    
    @RequestMapping("/login")
    public String login(@ModelAttribute("loginBean")LoginBean loginbean) {
        return "login";
    }
    
    @RequestMapping("/home")
    public String home(@ModelAttribute("loginBean")LoginBean loginbean,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute ("user") != null) {
            return "home";
        }
        response.sendRedirect(request.getContextPath() + "/login");
        return "login";
    }
    
    @RequestMapping(value="/access", method=RequestMethod.POST)
    public String access(HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("loginBean")LoginBean loginbean,
            Model model) {
        if (loginbean.getUsername().equalsIgnoreCase("test") && 
                loginbean.getPassword().equalsIgnoreCase("pass123")
                ) {
            request.getSession().setAttribute("user", "test");
            request.getSession().setAttribute("pass", "pass123");

            return "home";
        }
        
        return "login";
        
    }
    
    @RequestMapping("/logout")
    public String logout(@ModelAttribute("loginBean")LoginBean loginBean,
            HttpServletRequest request,
            HttpServletResponse response) {
        request.getSession().setAttribute("user", null);
        request.getSession().setAttribute("pass", null);
        request.getSession().invalidate();


        return "login";
    }
    /*
    @GetMapping("/form")
    public String form(@ModelAttribute("loginBean")LoginBean loginbean,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        return "form";
    }
    */
}
