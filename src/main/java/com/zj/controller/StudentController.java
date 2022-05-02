package com.zj.controller;

import com.zj.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController()
@RequestMapping("/student")
public class StudentController {

    @PostMapping("/register")
    public ModelAndView register(HttpServletRequest request, ModelAndView modelAndView, Student student) {
        modelAndView.addObject("student", student);
        //ip地址
        modelAndView.addObject("ip", request.getRemoteAddr());
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
