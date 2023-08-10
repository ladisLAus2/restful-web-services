package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello-world")
    public String sayHello(){
        return "<h1>hello world</h1>";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean sayHelloBean(){
        return new HelloWorldBean("hello world");
    }
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean sayHelloPathVariable(@PathVariable String name){
        return new HelloWorldBean("hello world " + name);
    }
}
