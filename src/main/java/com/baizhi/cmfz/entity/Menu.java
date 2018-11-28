package com.baizhi.cmfz.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private int id;
    private String title;
    private String iconcls;
    private String url;
    private List<Menu> menuList;


}
