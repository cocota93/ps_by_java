package com.ps.인프런.stringarray;

import java.util.*;

public class FIndAnagramsMapping {


    public Integer[] solution(int A[], int B[]) {
        Map<Integer, Integer> store = new HashMap<>();
//        List<Integer> result = new ArrayList<>();
        Integer result[] = new Integer[A.length];


        for (int i = 0; i < B.length; i++) {
            store.put(B[i], i);
        }

        for (int i = 0; i < A.length; i++) {
            Integer aValue = A[i];
            Integer bIndex = store.get(aValue);
            result[i] = bIndex;
        }
        
        return result;
    }

    public static void main(String[] args) {
        FIndAnagramsMapping proposal = new FIndAnagramsMapping();

        int[] A = {11, 27, 45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};
        Integer[] result = proposal.solution(A, B);
        System.out.println(Arrays.toString(result));
    }

}
