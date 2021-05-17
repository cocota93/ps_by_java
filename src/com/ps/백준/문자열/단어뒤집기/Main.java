package com.ps.백준.문자열.단어뒤집기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/단어뒤집기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String inputString = br.readLine();
        Pattern pattern = Pattern.compile("(<[\\w\\s]*>)|([\\w]*)");

        StringBuilder sb = new StringBuilder();
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            String subSplit = matcher.group(0);
            if(subSplit.isEmpty()){
                sb.append(" ");
                continue;
            }

            if(subSplit.charAt(0) == '<'){
                sb.append(subSplit);
            }else {
                sb.append(new StringBuilder(subSplit).reverse());
            }
        }

        System.out.println(sb);
    }

}
