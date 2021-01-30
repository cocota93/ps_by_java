package com.ps.백준.이진탐색.랜선자르기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//나무자르기 문제와 비슷한것 같다.


class Main {

    static long lines[];


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/이진탐색/랜선자르기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int alreadyHaveCount = Integer.parseInt(st.nextToken());
        int needCount = Integer.parseInt(st.nextToken());

        long minValue = 0;
        long maxValue = 0;
        lines = new long[alreadyHaveCount];
        for (int i = 0; i < alreadyHaveCount; i++) {
            lines[i] = Integer.parseInt(br.readLine());
//            maxValue = Math.max(maxValue, lines[i]);
        }
        Arrays.sort(lines);
        minValue = 1;
        maxValue = lines[lines.length - 1];


        long resultCount = 0;
        long resultLength = 0;
        while(minValue <= maxValue){
            long midValue = (minValue + maxValue) / 2;

            long tempCount = 0;
            for (long line : lines) {
                tempCount += line / midValue;
            }

            if(tempCount >= needCount){
                resultCount = Math.max(tempCount, resultCount);
                resultLength = Math.max(resultLength, midValue);
                minValue = midValue + 1;
            }else{
                maxValue = midValue - 1;
            }
        }

        System.out.println(maxValue);
    }

}
