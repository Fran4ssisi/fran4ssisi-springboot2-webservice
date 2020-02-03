package com.fran4ssisi.boot.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")

                 /*param
                 * API 테스트할때 사용될 요청 파라미터를 설정한다.
                 * 단 값은 String만 허용된다
                 * 숫자/날짜등의 데이터도 등록할때는 문자열로 변경해야 가능하다.
                 * */
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                /*jsonPath
                * JSON 응답값을 필드별로 검증할 수 있는 메소드
                * $를 기준으로 필드명을 명시한다
                * name과 amount를 검증하니 $.name, $amount로 검증한다.
                * */
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
