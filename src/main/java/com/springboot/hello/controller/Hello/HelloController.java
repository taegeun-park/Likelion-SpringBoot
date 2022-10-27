//@RequestMapping으로 구현하기
//Get형식의 요청만 받기위해서 어노테이션에 별도 설정을함.
package com.springboot.hello.controller.Hello;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {

    //http:///localhost:9090/api/v1/get-api/hello
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String gethello() {
        return "Hello World";
    }
}
