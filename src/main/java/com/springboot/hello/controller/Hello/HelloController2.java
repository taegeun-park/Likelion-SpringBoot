// 매개변수가 없는 GET 메서드 구현
package com.springboot.hello.controller.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController2 {

    //http:///localhost:9090/api/v1/get-api/hello
    @GetMapping(value = "/name")
    public String getName() {
        return "Taegeun";
    }
}