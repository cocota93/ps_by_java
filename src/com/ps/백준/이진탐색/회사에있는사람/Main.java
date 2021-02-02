package com.ps.백준.이진탐색.회사에있는사람;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

/*
* 리스트에 이름을 넣어두고 찾아보고 넣거나 삭제하는 방식으로 하니 시간초과 발생.
* n은 최대 10^6 = 1000000(백만)
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/이진탐색/회사에있는사람/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int logCount = Integer.parseInt(br.readLine());
        List<String> memberList = new ArrayList<>();
        for (int i = 0; i < logCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String command = st.nextToken();

            if("enter".equals(command)){
                memberList.add(name);
            }else if("leave".equals(command)){
                memberList.remove(name);
            }else{
                System.out.println("not support command");
            }
        }


        memberList.sort(Comparator.reverseOrder());

        for (String s : memberList) {
            System.out.println(s);
        }
    }

}
