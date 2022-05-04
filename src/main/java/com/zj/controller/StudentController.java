package com.zj.controller;

import com.zj.entity.Student;
import com.zj.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
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
    @Resource
    private StudentService studentService;
    @GetMapping("/findAll")
    @ResponseBody
    public List<Student> findAll() {
        List<Student> studentList = studentService.findAll();
        return studentList;
    }
    @GetMapping("/gotoList")
    public String gotoList(Model m) {
        List<Student> studentList = studentService.findAll();
        m.addAttribute("studentList", studentList);
        return "student-thymeleaf";
    }
}
