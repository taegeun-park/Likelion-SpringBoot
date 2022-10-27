// @PathVariable을 활용한 GET 메서드 구현
// @RequestParam을 이용한 GET 메서드 구현
package com.springboot.hello.controller.Hello;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api/")
public class HelloController5 {
    //http:///localhost:8080/api/v1/get-api/request1?name=Taegun&email=djqtek0525@naver.com&organization=likelion
    @GetMapping(value = "/request1")
    public String getRequestParam(MemberDto memberDto) {
        return memberDto.toString();
    }


}