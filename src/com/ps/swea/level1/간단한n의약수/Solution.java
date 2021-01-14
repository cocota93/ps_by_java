package com.ps.swea.level1.간단한n의약수;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level1/간단한n의약수/input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if(N % i == 0){
                result.add(i);
            }
        }

        result.sort(Comparator.comparingInt(Integer::intValue));

        result.forEach(value -> System.out.printf("%d ", value));
    }


}
