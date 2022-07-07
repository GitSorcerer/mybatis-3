package com.gaoh.mybatis.proxy.jdkdynamicinterface;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/19 10:32
 */
public class CalculateTest {

  @Test
  void test() {
    MyCalculate init = CalculateProxy.init();
    BigDecimal result = init.add(new BigDecimal("1"),
      new BigDecimal("2"),
      new BigDecimal("3"),
      new BigDecimal("4"),
      new BigDecimal("5"),
      new BigDecimal("6"),
      new BigDecimal("7"),
      new BigDecimal("8"),
      new BigDecimal("9"),
      new BigDecimal("10"));
    System.out.println(result);

    result = init.subtract(new BigDecimal("20"), new BigDecimal("10"), new BigDecimal("5"));
    System.out.println(result);


    result = init.multiplication(result, new BigDecimal("10"), new BigDecimal("5"));
    System.out.println(result);


    result = init.divisor(new BigDecimal("20"), new BigDecimal("10"), new BigDecimal("5"));
    System.out.println(result);
  }
}
