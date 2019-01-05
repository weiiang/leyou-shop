package com.leyou.common.utils;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author wq
 * @Date 2019/1/5 9:12
 * @Version 1.0.0
 */
public  class User{
    private Integer id;
    private String name;
    private Date birthday;

    public User(Integer id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
