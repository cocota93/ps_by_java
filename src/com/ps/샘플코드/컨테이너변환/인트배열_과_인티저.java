package com.ps.샘플코드.컨테이너변환;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class 인트배열_과_인티저 {



    public int[] solution(int[] arr) {
        //int배열 -> Integer
        Integer integer = Integer.valueOf(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining()));

        //int배열 -> String
        String result2 = Integer.valueOf(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining())).toString();

        //int배열 -> String리스트
        List<String> result3 = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.toList());

        //int배열 -> Integer리스트
        List<Integer> result4 = Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.toList());
        List<Integer> result5 = Arrays.stream(arr).boxed().collect(Collectors.toList());

        //배열이나 리스트같은 컨테이너를 다른걸로 변환시킬땐 Arrays.~ 를이용
        System.out.println("-----------");
        //단일객체는 toString으로 배열처럼 변환시킨뒤 원하는 컨테이너로 조립

        //Integer -> Integer리스트
        List<Integer> result6 = integer.toString().chars().mapToObj(Character::getNumericValue).collect(Collectors.toList());


        //Integer -> Integer배열
        Integer[] result7 = integer.toString().chars().mapToObj(Character::getNumericValue).toArray(Integer[]::new);


        //Integer -> int배열
        int[] result8 = integer.toString().chars().mapToObj(Character::getNumericValue).mapToInt(Integer::intValue).toArray();


        String strings1[] = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strings1[i] = String.valueOf(arr[i]);
        }

        List<String> strings2 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            strings2.add(String.valueOf(arr[i]));
        }







        return arr;
    }

    public static void main(String[] args) {
        인트배열_과_인티저 proposal = new 인트배열_과_인티저();

        int input[] = {1,1,3,3,0,1,1};
        int[] result = proposal.solution(input);
//        System.out.println(result);
    }

}
