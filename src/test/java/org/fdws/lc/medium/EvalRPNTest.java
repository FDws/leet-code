package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author FDws
 * @version Created on 2021/3/20 22:40
 */

public class EvalRPNTest {
  public int evalRPN(String[] tokens) {
    var oper = Map.<String, BiFunction<Integer, Integer, Integer>>
      of(
      "+", (a, b) -> a + b,
      "-", (a, b) -> a - b,
      "*", (a, b) -> a * b,
      "/", (a, b) -> a / b);

    var arr = new int[tokens.length];
    var idx = 0;
    for (String t : tokens) {
      if (oper.containsKey(t)) {
        var right = arr[idx - 1];
        var left = arr[idx - 2];
        arr[idx - 2] = oper.get(t).apply(left, right);
        idx--;
      } else {
        arr[idx++] = Integer.parseInt(t);
      }
    }

    return arr[0];
  }

  @Test
  void test() {
    System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
  }
}
