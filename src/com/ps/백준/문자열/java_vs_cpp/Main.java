package com.ps.백준.문자열.java_vs_cpp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/java_vs_cpp/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        String s = br.readLine();

        boolean isError = false;
        StringBuilder sb = new StringBuilder();
        if(s.contains("_")){
            //c++ -> java
            //소문자 or 밑줄만 가능 -> 대소문자만 가능

            if(s.charAt(0) == '_' || s.charAt(s.length() - 1) == '_'){
                isError = true;
            }

            for (int i = 0; i < s.length(); i++) {
                if(!Character.isLowerCase(s.charAt(i)) && s.charAt(i) != '_')
                    isError = true;
            }

            String[] s1 = s.split("_");
            if(s1.length == 0 || s1[0].isEmpty() ){
                isError = true;
            }


            if(!isError){
                sb.append(s1[0]);
                for (int i = 1; i < s1.length; i++) {
                    if(s1[i].isEmpty()) {
                        isError = true;
                        break;
                    }

                    String substring = Character.toUpperCase(s1[i].charAt(0)) + "";
                    if(s1[i].length() > 1){
                        substring += s1[i].substring(1);
                    }
                    sb.append(substring);
                }
            }
        }else{
            //java -> c++
            Pattern pattern = Pattern.compile("[a-z]+|[A-Z][a-z]*");
            Matcher matcher = pattern.matcher(s);

            int count = 0;
            while(matcher.find()){
                if(count == 0){
                    String group = matcher.group();
                    if(!Character.isLowerCase(group.charAt(0))){
                        isError = true;
                        break;
                    }

                    group = group.toLowerCase(Locale.ROOT);
                    sb.append(group);
                    count++;
                    continue;
                }

                String group = matcher.group().toLowerCase(Locale.ROOT);
                sb.append("_" + group);
                count++;
            }
        }



        if(isError){
            System.out.println("Error!");
        }else{
            System.out.println(sb);
        }
    }

}
