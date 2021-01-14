package com.ps.샘플코드.컨테이너변환;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 인트배열_과_인티저리스트 {


    public int[] solution(int[] arr) {
        //int배열 -> list<Integer>
        List<Integer> fixedArr = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for (Integer integer : fixedArr) {
            System.out.println(integer);
        }


        System.out.println("-----------");

        //list<Integer> -> int배열
        int[] ints = fixedArr.stream().mapToInt(Integer::intValue).toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }


        return arr;
    }

    public static void main(String[] args) {
        인트배열_과_인티저리스트 proposal = new 인트배열_과_인티저리스트();

        int input[] = {1,1,3,3,0,1,1};
        int[] result = proposal.solution(input);
        System.out.println(result);
    }

}
