package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ViewpagerDao;
import com.baizhi.cmfz.entity.Viewpager;
import com.baizhi.cmfz.service.ViewpagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ViewpagerServiceImpl implements ViewpagerService {
    @Autowired
    private ViewpagerDao viewpagerDao;


    @Override
    public Map selectByStartAndEnd(int page, int rows) {
        int start=rows*(page-1);
        Map map=new HashMap();
        List<Viewpager> list=viewpagerDao.selectAllByStartAndEnd(start,rows);
        //System.out.println(list);
        int count=viewpagerDao.countAll();
        //System.out.println(count);
        map.put("rows", list);
        map.put("total",count);
        return map;
    }

    @Override
    public void update(int id, String status) {
        viewpagerDao.update(id, status);
    }

    @Override
    public void delete(int id) {
        viewpagerDao.delete(id);
    }

    @Override
    public void insert(Viewpager viewpager) {
        viewpagerDao.add(viewpager);
    }
}
