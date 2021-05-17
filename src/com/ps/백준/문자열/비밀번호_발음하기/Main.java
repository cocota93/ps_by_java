package com.ps.백준.문자열.비밀번호_발음하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/비밀번호_발음하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        while(true){
            String inputString = br.readLine();
            if(inputString.equals("end")){
                break;
            }

            char[] inputCharArray = inputString.toCharArray();
            int vowelSequence = 0;
            int consonantSequence = 0;
            boolean includeVowel = false;
            boolean acceptable = true;

            if(vowelCheck(inputCharArray[0])){
                vowelSequence++;
                includeVowel = true;
            }else {
                consonantSequence++;
            }

            for (int i = 1; i < inputCharArray.length; i++) {
                boolean isVowel = vowelCheck(inputCharArray[i]);
                if(!includeVowel && isVowel){
                    includeVowel = true;
                }

                if(isVowel){
                    vowelSequence++;
                    consonantSequence = 0;
                }else{
                    consonantSequence++;
                    vowelSequence = 0;
                }

                if(vowelSequence >= 3 || consonantSequence >= 3){
                    acceptable = false;
                    break;
                }

                if(inputCharArray[i] == inputCharArray[i - 1] &&
                    (inputCharArray[i] != 'e' && inputCharArray[i] != 'o') ){
                    acceptable = false;
                    break;
                }
            }

            if(!includeVowel){
                acceptable = false;
            }

            if(acceptable){
                System.out.println("<" + inputString + ">" + " is acceptable.");
            }else {
                System.out.println("<" + inputString + ">" + " is not acceptable.");
            }
        }

    }

    private static boolean vowelCheck(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;

        return false;
    }

}
