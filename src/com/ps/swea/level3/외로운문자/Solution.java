package com.ps.swea.level3.외로운문자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;
import java.util.stream.Collectors;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level3/외로운문자/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T;
        T = Integer.parseInt(br.readLine());


        for (int test_case = 1; test_case <= T; ++test_case) {
            String s = br.readLine();
            char[] chars = s.toCharArray();
            List<Character> container = new ArrayList<>();
            for (char aChar : chars) {
                container.add(aChar);
            }

//            container.sort(Comparator.comparingInt(obj -> obj));
            container.sort(((o1, o2) -> o2 - o1));


            String result = "";
            for (;!container.isEmpty();){
                if(container.size() >= 2 && container.get(container.size() - 1) == container.get(container.size() - 2)){
                    container.remove(container.size() - 1);
                    container.remove(container.size() - 1);
                }else{
                    result += container.get(container.size() - 1);
                    container.remove(container.size() - 1);
                }
            }

            if("".equals(result)){
                result = "Good";
            }


            System.out.printf("#%d ", test_case);
//            container.forEach(obj -> System.out.printf("%c ", obj));
            System.out.printf("%s", result);
            System.out.printf("\n");
        }
    }

}
