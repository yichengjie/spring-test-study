package com.yicj.study.webmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yicj.study.webmvc.model.form.HelloCreateForm;
import com.yicj.study.webmvc.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
@SpringJUnitConfig
public class HelloController1Test {

    @MockBean
    private HelloService helloService ;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper ;

    @BeforeEach
    public void init(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController(helloService)).build();
        objectMapper = new ObjectMapper();
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
                ;
        mockMvc.perform(createMessage)
                .andExpect(status().isOk())
                .andDo(print());
    }

}
