package com.leyou.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommonApplication
 * @Description TODO
 * @Author wq
 * @Date 2018/11/6 15:50
 * @Version 1.0.0
 */
public class CommonApplication {
    public static void main(String[] args) {

        String s = "aaabccddf";

        String[] cs = s.split("");

        for (int i = 0; i < cs.length ; i++) {

            int count = 0;
            for (int j = 0; j < cs.length ; j++) {
                if (cs[j].equals(cs[i])){
                    count += 1;
                }else{
                    j = j -1;
                    i = i + count;
                    break;
                }
            }
            System.out.println(i);

            System.out.println(count);
        }

    }

    private static void method(int a, int b, List l, Integer c, Integer d) {
        a = a * 100;
        b = b * 100;
        l.add("3");
        d = d +10;
        c = c+ 10;
    }

    private static String  method1(String  a) {
      a = a +"sdadsa";
      return a;
    }


}
