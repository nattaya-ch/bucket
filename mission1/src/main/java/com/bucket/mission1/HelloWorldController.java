package com.bucket.mission1;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HelloWorldController {
    @RequestMapping("/hello")
    @ResponseBody
    public String greeting() {
        return "Hello, World";
    }
}