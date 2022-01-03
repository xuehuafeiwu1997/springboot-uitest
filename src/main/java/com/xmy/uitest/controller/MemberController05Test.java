package com.xmy.uitest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.xmy.uitest.entity.Member;
import com.xmy.uitest.service.MemberService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 对于MemberController04Test的改进，针对controller层中有相应的service层的benn的使用
 *
 * @author xmy
 * @date 2022/1/3 2:00 下午
 */
@RunWith(SpringRunner.class)
//使用@WebMvcTest只实例化Web层，而不是整个上下文。在具有多个Controller的应用程序中，甚至可以要求仅使用一个实例化如下面的写法
@WebMvcTest(MemberController.class)
public class MemberController05Test {

    @Autowired
    private MockMvc mockMvc;

    //模拟出一个userService
    @MockBean
    private MemberService memberService;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        //模拟memberService.getMemberById
        Member member = new Member();
        member.setId((long)1);
        member.setName("xumingyang");
        member.setSex("男");
        when(memberService.getMemberById(1)).thenReturn(member);

        String result = this.mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();

        System.out.println("Result: " + result);
    }
}
