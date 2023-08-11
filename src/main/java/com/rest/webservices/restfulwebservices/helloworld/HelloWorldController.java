package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;
    public HelloWorldController(MessageSource messageSource){
        this.messageSource= messageSource;
    }
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

    @GetMapping("/hello-world-inter")
    public String sayHelloInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("text", null, "default", locale);

    }

}
