package com.fran4ssisi.boot.spring.web;

import com.fran4ssisi.boot.spring.service.PostsService;
import com.fran4ssisi.boot.spring.web.dto.PostsResponseDto;
import com.fran4ssisi.boot.spring.web.dto.PostsSaveRequestDto;
import com.fran4ssisi.boot.spring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    //@Autowired를 하지 않는 이유는 생성자로 Bean을 주입받고 있기때문(롬복)
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

}
