package com.gaoh.mybatis.proxy.jdkdynamicinterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/19 10:28
 */
public class CalculateProxy {
// BigDecimal add(BigDecimal... adds);
//
//  BigDecimal subtract(BigDecimal minuend, BigDecimal... reductions);
//
//  BigDecimal multiplication(BigDecimal... multiplications);
//
//  BigDecimal divisor(BigDecimal dividend, BigDecimal... divisors);

  /**
   * @return 代理对象
   */
  public static MyCalculate init() {
    return (MyCalculate) Proxy.newProxyInstance(MyCalculate.class.getClassLoader(),
      new Class[]{MyCalculate.class},
      new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          String name = method.getName();
          BigDecimal results = new BigDecimal("0");
          if ("add".equals(name)) {
            if (args != null) {
              for (Object arg : args) {
                System.out.println(arg.getClass().getName());
                if (arg instanceof BigDecimal[]) {
                  BigDecimal[] adds = (BigDecimal[]) arg;
                  for (BigDecimal a : adds) {
                    results = results.add(a).setScale(2, BigDecimal.ROUND_HALF_UP);
                  }
                }
              }
            }
          } else if ("subtract".equals(name)) {
            if (args != null) {
              for (Object arg : args) {
                if (arg instanceof BigDecimal[]) {
                  BigDecimal[] subtracts = (BigDecimal[]) arg;
                  for (int i = 0; i < subtracts.length; ++i) {
                    if (i == 0) {
                      results = subtracts[i];
                    } else {
                      results = results.subtract(subtracts[i]).setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                  }
                }
              }
            }
          } else if ("multiplication".equals(name)) {
            if (args != null) {
              for (Object arg : args) {
                if (arg instanceof BigDecimal[]) {
                  BigDecimal[] multiplications = (BigDecimal[]) arg;
                  for (BigDecimal a : multiplications) {
                    results = results.multiply(a).setScale(2, BigDecimal.ROUND_HALF_UP);
                  }
                }
              }
            }
          }else if ("divisor".equals(name)) {
            if (args != null) {
              for (Object arg : args) {
                if (arg instanceof BigDecimal[]) {
                  BigDecimal[] divisors = (BigDecimal[]) arg;
                  for (int i = 0; i < divisors.length; ++i) {
                    if (i == 0) {
                      results = divisors[i];
                    } else {
                      results = results.divide(divisors[i], BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                  }
                }
              }
            }
          }else {
            System.out.println("暫無該方法！");
          }
          return results;
        }
      });
  }

}
