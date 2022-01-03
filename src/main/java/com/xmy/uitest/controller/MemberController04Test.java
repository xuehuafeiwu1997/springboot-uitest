package com.xmy.uitest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 使用@WebMvcTest只初始化controller层 这个有问题，一直跑不成功,因为只实例化了controller层，需要在
 * MemberController中注释掉相应的class
 *
 * @author xmy
 * @date 2022/1/3 1:51 下午
 */
@RunWith(SpringRunner.class)
//使用@WebMvcTest只实例化Web层，而不是整个上下文。在具有多个controller的应用程序中
// 甚至可以要求仅使用一个实例化，例如@WebMvcTest（UserController.class）
@WebMvcTest(MemberController.class)
public class MemberController04Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shoudReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }
}
