package com.gaoh.mybatis.mapper;

import com.gaoh.mybatis.model.Paper;

import java.util.List;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/16 15:45
 */
public interface PaperMapper {

  List<Paper> selectAll();

  List<Paper> selectByName(Paper model);

  Paper selectById(Paper model);

  int insert(Paper model);
}
