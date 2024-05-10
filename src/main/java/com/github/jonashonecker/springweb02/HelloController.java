package com.github.jonashonecker.springweb02;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
         return "Hello " + name + "!";
    }
}
