package com.xmy.uitest.entity;

import lombok.Data;

/**
 * @author xmy
 * @date 2022/1/3 9:31 上午
 */
@Data
public class User {
    public long id;
    public String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
