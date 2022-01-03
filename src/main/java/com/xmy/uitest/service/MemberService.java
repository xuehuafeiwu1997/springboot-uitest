package com.xmy.uitest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmy.uitest.dao.MemberDao;
import com.xmy.uitest.entity.Member;

/**
 * @author xmy
 * @date 2022/1/2 10:06 下午
 */
@Service
public class MemberService {

    @Autowired
    MemberDao memberDao;

    public Member getMemberById(long id) {
        System.out.println("执行到了这里");
        return memberDao.selectByPrimaryKey(id);
    }
}
