package com.ps.swea.level1.연월일달력;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level1/연월일달력/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        Map<Integer, Integer> calendarMap = new HashMap<>();
        calendarMap.put(1,31);
        calendarMap.put(3,31);
        calendarMap.put(5,31);
        calendarMap.put(7,31);
        calendarMap.put(8,31);
        calendarMap.put(10,31);
        calendarMap.put(12,31);

        calendarMap.put(9,30);
        calendarMap.put(11,30);
        calendarMap.put(4,30);
        calendarMap.put(6,30);

        calendarMap.put(2,28);

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            String s = String.valueOf(sc.next());
            Integer year = Integer.valueOf(s.substring(0, 4));
            Integer month = Integer.valueOf(s.substring(4, 4 + 2));
            Integer day = Integer.valueOf(s.substring(6, 6 + 2));

            Integer limitDay = calendarMap.getOrDefault(month, -1);
            String renderString;
            if(month <= 0 || day <= 0 || day > limitDay){
                renderString = "-1";
            }else{
                renderString = String.format("%04d/%02d/%02d", year, month, day);
            }

            System.out.printf("#%d ", test_case);
            System.out.printf(renderString);
            System.out.printf("\n");
        }
    }

}
