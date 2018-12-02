package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Chapter;

public interface ChapterDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);

    void add(Chapter chapter);
}