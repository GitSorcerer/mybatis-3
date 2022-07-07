package com.gaoh.mybatis.proxy.jdkdynamicinterface;

import java.math.BigDecimal;

/**
 * @author gaoh
 * @version 1.0
 * @date 2020/1/19 10:24
 */
public interface MyCalculate {

  BigDecimal add(BigDecimal... adds);

  BigDecimal subtract(BigDecimal... reductions);

  BigDecimal multiplication(BigDecimal... multiplications);

  BigDecimal divisor(BigDecimal... divisors);

}
