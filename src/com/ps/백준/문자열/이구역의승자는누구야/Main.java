package com.ps.백준.문자열.이구역의승자는누구야;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
* https://www.acmicpc.net/source/share/6e850669b3f14302814efc3e7117385b
* */

class Main {

    static int[] needPaintCount = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/이구역의승자는누구야/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        String inputString = br.readLine();
        char[] inputCharArray = inputString.toCharArray();

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (char inputChar : inputCharArray) {
            a.add(needPaintCount[inputChar - 'A']);
        }

        while(a.size() > 1){
            b.clear();

            for (int i = 0; i + 1 < a.size(); i += 2) {
                int sum = (a.get(i) + a.get(i + 1)) % 10;
                b.add(sum);
            }

            if(a.size() % 2 == 1){
                b.add(a.get(a.size() - 1));
            }

            a.clear();
            a.addAll(b);
        }

        Integer result = a.get(0);
        if(result % 2 == 0){
            System.out.println("You're the winner?");
        }else{
            System.out.println("I'm a winner!");
        }

    }

}
