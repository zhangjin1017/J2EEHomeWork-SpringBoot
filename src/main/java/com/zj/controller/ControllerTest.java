package com.zj.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ControllerTest {
    @RequestMapping("/hello")
    public String hello() {
        return "hello 江苏海洋大学";
    }
    @RequestMapping("/t1")
    public String test() {
        System.out.println("t1------");
        System.out.println("t1------");
        System.out.println("t1------");
        return "t1";
    }
    @PostMapping("/t2/{name}")
    public String test2(@PathVariable("name") String name) {
        System.out.println("t2------");
        System.out.println(name+"------");
        System.out.println("t2------");
        return "t2";
    }
}

