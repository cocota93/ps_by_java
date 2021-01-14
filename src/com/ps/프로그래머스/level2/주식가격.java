package com.ps.프로그래머스.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 주식가격 {

    public int[] solution(int[] prices) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if(prices[i] > prices[j]){
                    break;
                }
            }

            result.add(count);
        }
        

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        주식가격 proposal = new 주식가격();

        int input[] = {1, 2, 3, 2, 3};
        int[] result = proposal.solution(input);
        System.out.println(Arrays.toString(result));
    }

}
