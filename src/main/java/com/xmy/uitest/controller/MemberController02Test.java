package com.xmy.uitest.controller;

import java.util.regex.Matcher;

import org.assertj.core.internal.bytebuddy.matcher.StringMatcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 这种方式是通过将TestRestTemplate注入进来，进行发送请求测试，缺点是需要启动服务器
 * @author xmy
 * @date 2022/1/3 9:55 上午
 */
@RunWith(SpringRunner.class)
//SpringBootTest.WebEnvironment.RANDOM_PORT设置随机端口启动服务器（有助于避免测试环境中的冲突）
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberController02Test {
    //使用@LocalServicePort将端口注入进来
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        Assert.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class),
                Matchers.containsString("Hello World"));
        Assert.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class),
                Matchers.containsString("Hello World"));
    }
}
