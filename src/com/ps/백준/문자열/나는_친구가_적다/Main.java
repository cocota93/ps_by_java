package com.ps.백준.문자열.나는_친구가_적다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
* 찾고자 하는 키워드의 순서와 똑같이 계속 체크만 해도 충분히 풀수 있을듯함.
* q가 나올떄까지 찾고, w가 나올떄까지 찾고 ... 반복. 중간에 다른게 섞여있어도 상관없음.
* 연속해야된다는 조건이 없으니 순서만 맞으면 되기떔에.
* 하지만 정규표현식을 연습할겸 정규표현식으로 풀이.
*
*
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/나는_친구가_적다/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String s = br.readLine();
        String k = br.readLine();

        StringBuilder regex = new StringBuilder();
        //\d*?q\d*?w\d*?e\d*?r\d*?t\d*?y\d*?
        regex.append("\\d*?");
        for (int i = 0; i < k.length(); i++) {
            regex.append(k.charAt(i)).append("\\d*?");
        }

        Pattern stringPattern = Pattern.compile(regex.toString());
        Matcher m = stringPattern.matcher(s);
        System.out.println(m.find() ? 1 : 0);
    }

}
