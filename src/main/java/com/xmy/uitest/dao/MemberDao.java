package com.xmy.uitest.dao;

import org.apache.ibatis.annotations.Mapper;

import com.xmy.uitest.entity.Member;

/**
 * @author  xmy
 * @date  2022/1/2 10:13 下午
 */
@Mapper
public interface MemberDao {
    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}
