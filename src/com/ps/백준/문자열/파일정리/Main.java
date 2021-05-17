package com.ps.백준.문자열.파일정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/파일정리/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        Map<String, Integer> countingMap = new HashMap<>();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String s = br.readLine();

            String[] split = s.split("\\.");
            String ext = split[1];
            countingMap.put(ext, countingMap.getOrDefault(ext, 0) + 1);
        }


        List<String> keySortList = new ArrayList<>(countingMap.keySet());
        keySortList.sort(Comparator.naturalOrder());
        for (String key : keySortList) {
            Integer count = countingMap.get(key);
            System.out.println(key + " " + count);
        }

//        for (Map.Entry<String, Integer> entry : countingMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
    }

}
