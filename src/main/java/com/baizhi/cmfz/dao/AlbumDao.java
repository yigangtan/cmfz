package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Album;

import java.util.List;

public interface AlbumDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Album record);

    int insertSelective(Album record);

    Album selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);

    List<Album> selectAll();
}