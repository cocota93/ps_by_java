package com.ps.샘플코드.브루트포스.for문.일곱난쟁이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/샘플코드/브루트포스/for문/일곱난쟁이/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int dwarf[] = new int[9];
        for (int i = 0; i < dwarf.length; i++) {
            int height = Integer.parseInt(br.readLine());
            dwarf[i] = height;
        }

        List<Integer> result = new ArrayList<>();
        int originSum = Arrays.stream(dwarf).sum();
        for (int i = 0; i < dwarf.length; i++) {

            for (int j = i + 1; j < dwarf.length; j++) {
                int sum = originSum;
                sum -= dwarf[i];
                sum -= dwarf[j];

                if(sum != 100) continue;

                for (int k = 0; k < dwarf.length; k++) {
                    if(k == i) continue;
                    if(k == j) continue;

                    result.add(dwarf[k]);
                }

                result.sort(Comparator.comparingInt(Integer::intValue));
                result.forEach(System.out::println);
                return;
            }
        }
    }

}
