package com.gaoh.mybatis.test;

import com.gaoh.mybatis.mapper.BlogsMapper;
import com.gaoh.mybatis.mapper.PaperMapper;
import com.gaoh.mybatis.model.Blogs;
import com.gaoh.mybatis.model.Paper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/16 12:26
 */
public class MybatisTest {
  public static SqlSessionFactory sqlSessionFactory;

  @BeforeAll
  public static void init() {
    String resource = "mybatis-config.xml";
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
  }

  @Test
  public void test() {

    SqlSession sqlSession = sqlSessionFactory.openSession();

    Object o = sqlSession.selectList("com.gaoh.mybatis.mapper.BlogsMapper.selectAll");
    System.out.println(o);

  }

  @Test
  public void test1() {

    SqlSession sqlSession = sqlSessionFactory.openSession();
    BlogsMapper mapper = sqlSession.getMapper(BlogsMapper.class);


    Blogs blogs = new Blogs();
    blogs.setId(1);
    blogs = mapper.selectById(blogs);
    System.out.println(blogs);
    blogs.setId(2);
    blogs = mapper.selectById(blogs);
    System.out.println(blogs);
    blogs.setId(2);
    blogs = mapper.selectById(blogs);
    System.out.println(blogs);
  }

  @Test
  public void test2() {

    SqlSession sqlSession = sqlSessionFactory.openSession();
    PaperMapper mapper = sqlSession.getMapper(PaperMapper.class);


    Paper paperModel = new Paper();
    paperModel.setId(1);
    paperModel = mapper.selectById(paperModel);
    System.out.println(paperModel);


    paperModel = new Paper();
    paperModel.setCreateDate(new Date());
    paperModel.setFileName(UUID.randomUUID().toString());
    paperModel.setFilePath(UUID.randomUUID().toString());

    int insert = mapper.insert(paperModel);
    sqlSession.commit();
    System.out.println(insert > 0 ? "插入成功" : "插入失败!");


    List<Paper> papers = mapper.selectAll();
    for (Paper model : papers) {
      System.out.println(model);
    }
  }


  @Test
  void test3() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    PaperMapper mapper = sqlSession.getMapper(PaperMapper.class);
    Paper paperModel = new Paper();
    paperModel.setId(1);
    paperModel = mapper.selectById(paperModel);
    System.out.println(paperModel);

    paperModel.setFileName("文件");
    List<Paper> papers = mapper.selectByName(paperModel);
    System.out.println(papers);
  }
}
