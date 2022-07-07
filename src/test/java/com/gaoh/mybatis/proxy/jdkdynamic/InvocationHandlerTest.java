package com.gaoh.mybatis.proxy.jdkdynamic;

import java.lang.reflect.Proxy;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/16 17:28
 * <p>
 * <p>
 * 对具体的某个方法进行增强（代理）
 */
public class InvocationHandlerTest {

  public static void main(String[] args) {
    IVehical iVehical = new IVehicalImpl();

    //@param 接口的类加载器
    //@param 代理类实现的接口
    //@param 实现InvocationHandler接口的对象 处理代理的相关逻辑
    IVehical vehical = (IVehical) Proxy.newProxyInstance(iVehical.getClass().getClassLoader(),
      IVehicalImpl.class.getInterfaces(),
      new VehicalInvacationHandler(iVehical));

    vehical.run();


    System.out.println("=============================动态代理=================================");
    IVehical model = new IVehicalImpl();
    IVehical finalModel = model;
    model = (IVehical) Proxy.newProxyInstance(iVehical.getClass().getClassLoader(),
      new Class[]{IVehical.class},
      (proxy, method, args1) -> {
        System.out.println("执行相关的业务逻辑！");
        method.invoke(finalModel, args1);
        System.out.println("执行相关的业务逻辑！");
        return finalModel;
      });
    model.run();
  }
}
