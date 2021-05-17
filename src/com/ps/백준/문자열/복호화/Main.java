package com.ps.백준.문자열.복호화;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/복호화/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < n; testCase++) {
            String password = br.readLine();
            Map<Character, Integer> countingMap = new HashMap<>();

            char[] passwordCharArray = password.toCharArray();
            for (char c : passwordCharArray) {
                if(c == ' ') continue;

                countingMap.put(c,countingMap.getOrDefault(c, 0) + 1);
            }

            int maxCount = -1;
            char targetCharacter = '0';
            for (Map.Entry<Character, Integer> entry : countingMap.entrySet()) {
                if(maxCount < entry.getValue()){
                    maxCount = entry.getValue();
                    targetCharacter = entry.getKey();
                }
            }


            boolean ambiguity = false;
            for (Map.Entry<Character, Integer> entry : countingMap.entrySet()) {
                if(targetCharacter != entry.getKey() && maxCount <= entry.getValue()){
                    ambiguity = true;
                    break;
                }
            }

            if(ambiguity){
                System.out.println("?");
            }else{
                System.out.println(targetCharacter);
            }

        }
    }

}
