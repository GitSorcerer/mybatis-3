package com.gaoh.mybatis.proxy.cglib;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/19 9:45
 */
public class Dog {
  /**
   * 加上  final 该类是不可被动态代理的
   * @param name
   */
  final public void run(String name) {
    System.out.println("狗" + name + "----run");
  }

  public void eat() {
    System.out.println("狗----eat");
  }
}
