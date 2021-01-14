package com.ps.swea.level1.중간값찾기;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level1/중간값찾기/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        int arr[] = new int[T];
        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            arr[test_case - 1] = sc.nextInt();
        }
        Arrays.sort(arr);



        System.out.println(arr[T/2]);
    }

}
