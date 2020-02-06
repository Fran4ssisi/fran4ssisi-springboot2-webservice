package com.fran4ssisi.boot.spring.web;

import com.fran4ssisi.boot.spring.service.Postsservice;
import com.fran4ssisi.boot.spring.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    //@Autowired를 하지 않는 이유는 생성자로 Bean을 주입받고 있기때문(롬복)
    private final Postsservice postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

}
