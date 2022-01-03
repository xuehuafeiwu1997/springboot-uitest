package com.xmy.uitest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmy.uitest.entity.Member;
import com.xmy.uitest.entity.User;
import com.xmy.uitest.service.MemberService;

/**
 * @author xmy
 * @date 2022/1/2 10:34 下午
 */
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

//    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    @GetMapping("/user/{id}")
//    public String getUser(@PathVariable("id") long id) {
//        Member result = memberService.getMemberById(id);
//        return result.toString();
//    }

    @RequestMapping
    public String index() {
        return "Hello world!";
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> listUser () {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "许明洋"));
        list.add(new User(2, "郝燕挺"));
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getInfo(@PathVariable("userId") Integer userId) {
        User user = new User(3, "测试");
        Member member = memberService.getMemberById(userId);
        System.out.println("member的值为" + member);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
