package com.ps.백준.그리디.폴리오미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


class Main {



    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그리디/폴리오미노/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        String origin = br.readLine();
        String compareA = "XXXX";
        String compareB = "XX";
        StringBuilder sb = new StringBuilder(origin);

        for (int i = 0; i < origin.length(); ) {
            {
                int startIdx = i;
                int endIdx = i + compareA.length();
                if (endIdx <= origin.length()) {
                    String substring = origin.substring(startIdx, endIdx);
                    if (substring.equals(compareA)) {
                        sb.replace(startIdx, endIdx, "AAAA");
                        i += compareA.length();
                        continue;
                    }
                }
            }

            {
                int startIdx = i;
                int endIdx = i + compareB.length();

                if (endIdx <= origin.length()) {
                    String substring = origin.substring(startIdx, endIdx);
                    if (substring.equals(compareB)) {
                        sb.replace(startIdx, endIdx, "BB");
                        i += compareB.length();
                        continue;
                    }
                }
            }

            i++;
        }


        String checker = sb.toString();
        for (char c : checker.toCharArray()) {
            if(c == 'X'){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(sb.toString());
    }

}
