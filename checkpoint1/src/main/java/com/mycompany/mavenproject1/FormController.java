/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author ryanoneill
 */
@Controller
public class FormController {
    @GetMapping("/form")
    public String form(@ModelAttribute("loginBean")LoginBean loginbean,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        return "form";
    
    }
}
