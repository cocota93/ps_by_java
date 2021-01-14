package com.ps.인프런.stringarray;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {
//    public static int[] solution(int[] num, int target) {
//
//        //복잡도가 n2이라서 별로 안좋다
//        for (int i = 0; i < num.length; i++) {
//            for (int j = i; j < num.length; j++) {
//                if(num[i] + num[j] == target){
//                    return new int[]{i, j};
//                }
//            }
//        }
//
//        return new int[]{};
//    }

    public static int[] solution(int[] num, int target) {
        Map<Integer, Integer> cave = new HashMap<>();

        //Array + map(키이용)은 자주나오는 패턴
        for (int i = 0; i < num.length; i++) {
            if(cave.containsKey(num[i])){
                return new int[]{cave.get(num[i]), i};
            }else{
                cave.put(target - num[i], i);
            }
        }

        return new int[]{};
    }


    public static void main(String[] args) {
        int[] num = {2,7,11,15};
        int target  = 9;
        int[] result = solution(num, target);
        System.out.println(Arrays.toString(result));
    }
}
