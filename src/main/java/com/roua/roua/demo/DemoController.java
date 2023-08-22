package com.roua.roua.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping
    public String sayHello() {
        return "hello world";
    }


    @GetMapping("/hello2")
    public String sayHello2() {
        return "hello world2";
    }
}
// {
//     "firstName" : "redouane",
//     "lastName" : " soul",
//     "email" : "soulredouane@gmail.com",
//     "password" : "life_?"
// }