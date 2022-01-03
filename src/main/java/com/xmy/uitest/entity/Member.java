package com.xmy.uitest.entity;

import lombok.Data;

/**
 * @author xmy
 * @date 2022/1/2 10:13 下午
 */
@Data
public class Member {
    private Long id;

    private String name;

    private String sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
