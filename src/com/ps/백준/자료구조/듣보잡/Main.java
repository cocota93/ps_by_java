package com.ps.백준.자료구조.듣보잡;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;
import java.util.stream.Collectors;


/*
* add, remove해서 풀수도있을것 같고 각 이름을 카운팅해서 2이상인 경우만 구해도 될것같은데
* 문제에서 원하는 답이 뭔지 모르겠다.
* 음...지금보니 리스트에 그냥 add, remove해서 풀려고 하면 탐색 횟수가 너무 많아져서 시간초과삘이다.
*
* map이 적당할듯
*
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/자료구조/듣보잡/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine(), " ");
        int countGroupA = Integer.parseInt(st.nextToken());
        int countGroupB = Integer.parseInt(st.nextToken());

        Map<String, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < countGroupA; i++) {
            resultMap.put(br.readLine(), 1);
        }

        for (int i = 0; i < countGroupB; i++) {
            String name = br.readLine();
            resultMap.put(name, resultMap.getOrDefault(name, 0) + 1);
        }

        List<String> resultList = resultMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());


        System.out.println(resultList.size());
        for (String s : resultList) {
            System.out.println(s);
        }


    }

}
