package com.ps.백준.문자열.애너그램;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/애너그램/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");

            String s1 = st.nextToken();
            int[] alphaCountArray1 = new int['z' - 'a' + 1];
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) == ' ') continue;
                alphaCountArray1[s1.charAt(i) - 'a']++;
            }

            String s2 = st.nextToken();
            int[] alphaCountArray2 = new int['z' - 'a' + 1];
            for (int i = 0; i < s2.length(); i++) {
                if(s2.charAt(i) == ' ') continue;
                alphaCountArray2[s2.charAt(i) - 'a']++;
            }

            boolean isAnagram = true;
            if(s1.length() != s2.length()) isAnagram = false;
            else {
                for (int i = 0; i < alphaCountArray1.length; i++) {
                    if(alphaCountArray1[i] != alphaCountArray2[i]){
                        isAnagram = false;
                        break;
                    }
                }
            }


            if(isAnagram){
                System.out.println(s1 + " & " + s2 + " " + "are anagrams.");
            }else {
                System.out.println(s1 + " & " + s2 + " " + "are NOT anagrams.");
            }
        }
    }

}
