package com.ps.백준.분할정복.숫자카드;

import java.io.*;
import java.util.*;

/*
* 제한시간 2초
* 숫자카드의 개수 N 최대 500000(오십만)
* 가지고있는지 확인해야할 숫자카드 M 의 개수 촤대 500000(오십만)
* M * N = 계산해보면 2억5천. 1억이 1초정도니까 제한시간 초과.
*
* 해쉬맵으로 하면 되지않을까??
*
*
*
* 분할정복 문제인데 어디가 분할정복인건지 감이 안오네
* 풀이보고 의도에 맞게 다시 풀어봐야할듯
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/분할정복/숫자카드/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Set<Integer> set = new HashSet<>();
        int cardCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cardCount; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int needSearchCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < needSearchCount; i++) {
            int tryNum = Integer.parseInt(st.nextToken());
            boolean contains = set.contains(tryNum);
//            System.out.printf("%d ", contains ? 1 : 0);
            bw.write(contains ? 1 + " " : 0 + " ");
        }

        bw.flush();
        bw.close();

    }

}
