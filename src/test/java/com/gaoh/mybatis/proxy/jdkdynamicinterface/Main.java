package com.gaoh.mybatis.proxy.jdkdynamicinterface;

import java.lang.reflect.Proxy;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/19 9:14
 */
public class Main {

  public static void main(String[] args) {
    Hello hello = (Hello) Proxy.newProxyInstance(
      Hello.class.getClassLoader(), // 传入ClassLoader
      new Class[]{Hello.class}, // 传入要实现的接口
      (proxy, method, args1) -> {
        System.out.println(method);
        if (method.getName().equals("morning")) {
          System.out.println("Good morning, " + args1[0]);
        }
        if (method.getName().equals("run")) {
          System.out.println("Good run, " + System.currentTimeMillis());
        }
        return null;
      }); // 传入处理调用方法的InvocationHandler
    hello.morning("Bob");
    hello.run();
  }
}
