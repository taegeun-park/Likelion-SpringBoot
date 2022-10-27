// @PathVariable을 활용한 GET 메서드 구현
package com.springboot.hello.controller.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/get-api/")
public class HelloController3 {
    //http:///localhost:9090/api/v1/get-api/hello
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }
}