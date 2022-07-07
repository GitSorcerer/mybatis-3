package com.gaoh.mybatis.proxy.jdkdynamicinterface;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/19 9:56
 */
public class TestProxy {


  @Test
  void test() {
    World world = (World) Proxy.newProxyInstance(World.class.getClassLoader(), new Class[]{World.class}, new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();

        if ("show".equals(name)) {
          if (args != null) {
            StringBuilder sb = new StringBuilder();
            for (Object arg : args) {
              sb.append(arg.toString()).append("~");
            }
            System.out.println("这是Show方法...参数:" + sb.toString());
          } else {
            System.out.println("这是Show方法...");
          }
        }
        return null;
      }
    });

    world.show();
    world.show("hello,world!");
  }
}
