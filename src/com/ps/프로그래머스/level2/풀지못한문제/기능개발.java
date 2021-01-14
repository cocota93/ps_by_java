package com.ps.프로그래머스.level2.풀지못한문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> fixedProgress = Arrays.stream(progresses).boxed().collect(Collectors.toList());
        List<Integer> fixedSpeeds = Arrays.stream(speeds).boxed().collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        int size = fixedProgress.size();
        int oldCount = 0;

        for (; oldCount < size; ) {
            for (int j = 0; j < size; j++) {
                Integer value = fixedProgress.get(j);
                fixedProgress.set(j, value + fixedSpeeds.get(j));
            }

            int count = (int) fixedProgress.stream().filter(obj -> obj >= 100).count();
            if(oldCount != count){
                result.add((count - oldCount));
                oldCount = count;
            }
        }




        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        기능개발 proposal = new 기능개발();

        int[] result = proposal.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(result));
    }

}
