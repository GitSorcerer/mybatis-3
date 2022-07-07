package com.gaoh.mybatis.proxy.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/16 17:27
 */
public class VehicalInvacationHandler implements InvocationHandler {
  private final IVehical vehical;

  public VehicalInvacationHandler(IVehical vehical) {
    this.vehical = vehical;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("---------before-------");
    Object invoke = method.invoke(vehical, args);
    System.out.println("---------after-------");
    return invoke;
  }
}
