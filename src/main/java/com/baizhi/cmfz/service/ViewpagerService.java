package com.baizhi.cmfz.service;



import com.baizhi.cmfz.entity.Viewpager;

import java.util.Map;

public interface ViewpagerService {
    public Map selectByStartAndEnd(int page, int rows);

    public void update(int id,String status);

    public void delete(int id);

    public void insert(Viewpager viewpager);
}
