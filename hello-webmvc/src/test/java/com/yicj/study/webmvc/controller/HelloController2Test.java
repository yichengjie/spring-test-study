package com.yicj.study.webmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yicj.study.webmvc.model.form.HelloCreateForm;
import com.yicj.study.webmvc.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yicj
 * @date 2023年11月01日 14:27
 */
@Slf4j
@SpringJUnitWebConfig
public class HelloController2Test {

    @MockBean
    private HelloService helloService ;
//    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper ;

    @Configuration
    @EnableWebMvc
    @Import(HelloController.class)
    static class Config{

    }

    @BeforeEach
    public void init(WebApplicationContext wac){
        objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void hello(){

        log.info("hello world");
    }

    @Test
    public void index() throws Exception {
        given(helloService.hello("张三")).willReturn("hello, 张三") ;
        MockHttpServletRequestBuilder createMessage = get("/hello/index")
                ;
        mockMvc.perform(createMessage)
                .andExpect(status().isOk())
                .andDo(result -> log.info("result : {}", result)) ;
    }

    @Test
    public void create() throws Exception {
        HelloCreateForm form = new HelloCreateForm() ;
        form.setName("李四");
        given(helloService.hello("张三")).willReturn("hello, 张三") ;
        MockHttpServletRequestBuilder createMessage = post("/hello/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(form))
                //.content("{\"username\":\"goldchen\",\"password\":\"123456\"}")
                ;
        mockMvc.perform(createMessage)
                .andExpect(status().isOk())
                .andDo(print());
    }

}
