package com.gaoh.mybatis.mapper;

import com.gaoh.mybatis.model.Blogs;

import java.util.List;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/14 15:11
 */
public interface BlogsMapper {

  List<Blogs> selectAll();

  List<Blogs> selectByTitle(Blogs blogs);

  Blogs selectById(Blogs blogs);

}
