package com.ps.백준.그리디.대회or인턴;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 여학생 수가 상당히 많아서 인턴은 다 여학생으로 보내는 경우같은걸 처리해줘야함
*
* 근데 이거랑 그리디랑 뭔상관이야?
* */
class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그리디/대회or인턴/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int womanCount = Integer.parseInt(st.nextToken());
        int manCount = Integer.parseInt(st.nextToken());
        int needInternCount = Integer.parseInt(st.nextToken());

        int makeTeamCount = 0;
        while(manCount >= 1 && womanCount >= 2){
            makeTeamCount++;
            manCount -= 1;
            womanCount -= 2;
        }

        if(manCount > 0){
            needInternCount -= manCount;
            manCount = 0;
        }

        if(womanCount > 0){
            needInternCount -= womanCount;
            womanCount = womanCount;
        }

        for (int i = needInternCount; i > 0; i -= 3) {
            makeTeamCount--;
        }

        if(makeTeamCount < 0){
            makeTeamCount = 0;
        }

        System.out.println(makeTeamCount);

    }

}
