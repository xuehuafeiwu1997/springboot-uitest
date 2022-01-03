package com.xmy.uitest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 使用@AutoConfigureMockMvc注解自动注入MockMvc
 * @author xmy
 * @date 2022/1/3 10:09 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //不启动服务器，使用mockMvc进行测试http请求。启动了完整的spring应用程序上下文，但是没有启动服务器
public class MemberController03Test {

    @Autowired
    private MockMvc mockMvc;

    /**
     * .perform():执行一个MockMvcRequestBuilders的请求，MockMvcRequestBuilders
     * .andDo():添加一个MockMvcResultHandlers结果处理器，可以用于打印结果输出
     * .andExpect: 添加MockMvcResultMatchers验证规则，验证执行结果是否正确
     */
    @Test
    public void shouldReturnDefaultMesssage() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }
}
