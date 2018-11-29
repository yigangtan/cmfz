package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Viewpager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewpagerDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Viewpager record);

    int insertSelective(Viewpager record);

    Viewpager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Viewpager record);

    int updateByPrimaryKey(Viewpager record);

    List<Viewpager> selectAllByStartAndEnd(@Param("start") int start, @Param("rows") int rows);

    int countAll();

    void update(@Param("id") int id,@Param("status") String status);

    void delete(int id);

    void add(Viewpager viewpager);
}