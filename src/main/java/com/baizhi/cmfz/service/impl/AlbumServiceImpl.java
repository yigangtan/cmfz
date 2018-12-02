package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AlbumDao;
import com.baizhi.cmfz.dao.ChapterDao;
import com.baizhi.cmfz.entity.Album;
import com.baizhi.cmfz.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Override
    public Map selectAll() {
        Map map=new HashMap();
        List<Album> list=albumDao.selectAll();
        //System.out.println(list);
        map.put("rows",list);
        return map;
    }
}
