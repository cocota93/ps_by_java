package com.ps.백준.DP.쉬운계단수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;



class Main {

    static int mod = 1000000000;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/쉬운계단수/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //계단수 ex ) 45656

        //길이가 n인 계단수의 개수 찾는 문제
        //길이는 1이상 100이하
        //길이가 100까지 갈수있으니까 정수로 하면 안될꺼같고 문자열로 처리해야할것같은데
        int n = Integer.parseInt(br.readLine());

        //이게 왜 ㅇp문제지? 잘 감이안오네

        //소수의 경우 왼쪽에서 오른쪽으로 갈수록 자릿수가 증가하는 반면, 자연수는 그 반대다.
        //https://st-lab.tistory.com/134


        long[][] dp = new long[n][10];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for (int digit = 1; digit < dp.length; digit++) {

            for (int number = 0; number < dp[0].length; number++) {
                if(number == 0){
                    dp[digit][1] += dp[digit - 1][number] % mod;
                }else if(number == 9){
                    dp[digit][8] += dp[digit - 1][number] % mod;
                }else {
                    dp[digit][number - 1] += dp[digit - 1][number] % mod;
                    dp[digit][number + 1] += dp[digit - 1][number] % mod;
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        long answer = 0;
        for (int i = 0; i < dp[0].length; i++) {
//            answer += dp[dp.length - 1][i] % mod;
            answer = (answer + dp[dp.length - 1][i]) % mod;
        }

        System.out.println(answer);
    }

}
