package com.baizhi.cmfz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private String dharmaName;
    private String province;
    private String city;
    private String sex;
    private String sign;
    private String head_pic;
    private Date date;
    private int teacher_id;

    public User() {
    }

    public User(String username, String password, String salt, String dharmaName, String province, String city, String sex, String sign, String head_pic, Date date, int teacher_id) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.dharmaName = dharmaName;
        this.province = province;
        this.city = city;
        this.sex = sex;
        this.sign = sign;
        this.head_pic = head_pic;
        this.date = date;
        this.teacher_id = teacher_id;
    }
}
