package com.gaoh.mybatis.proxy.jdkdynamic;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/16 17:26
 */
public class IVehicalImpl implements IVehical {
  @Override
  public void run() {
    System.out.println("代理我吧...");
  }
}
