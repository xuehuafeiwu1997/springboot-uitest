package com.xmy.uitest.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.notNullValue;

/**
 * @author xmy
 * @date 2022/1/3 9:41 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest //@SpringBootTest表示是一个可以启动容器的测试类
public class MemberController01Test {

    @Autowired
    private MemberController memberController;

    @Test
    @DirtiesContext
    public void testContextLoads() {
        System.out.println("memberController的值为" + memberController);
        Assert.assertThat(memberController, notNullValue());
    }

    @Test
    @DirtiesContext
    public void testContextLoads02() {
        Assert.assertThat(memberController, notNullValue());
    }
}
