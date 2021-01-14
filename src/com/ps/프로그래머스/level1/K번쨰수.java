package com.ps.프로그래머스.level1;

import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K번쨰수 {


    public int[] solution(int array[], int[][] commands) {

        List<Integer> resultList = new ArrayList<>();

        for (int[] command : commands) {
            int cutStart = command[0] - 1;
            int cutEnd = command[1];
            int k = command[2] - 1;

//            Arrays.stream(array)
//                    .mapToObj(index -> index)
//                    .forEach(System.out::println);

            int[] subArray = Arrays.stream(Arrays.copyOfRange(array, cutStart, cutEnd)).sorted().toArray();
            int result = subArray[k];

            System.out.println("subArray : " + Arrays.toString(subArray) + ", k_index: " + k + ", k_value : " + result);

            resultList.add(result);
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        K번쨰수 proposal = new K번쨰수();

        int array[] = {1, 5, 2, 6, 3, 7, 4};
        int commands[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = proposal.solution(array, commands);
        System.out.println(Arrays.toString(result));
    }

}
