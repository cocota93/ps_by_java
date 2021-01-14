package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 예산 {

    public int solution(int[] d, int budget) {
        //solution
        String a = "solution";
        Arrays.sort(d);

        int answer = 0;
        long tempSum = 0;
        for (answer = 0; answer < d.length; answer++) {
            if(tempSum + d[answer] <= budget){
                tempSum += d[answer];
            }else{
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        예산 proposal = new 예산();

        int input[] = {1, 3, 2, 5, 4};
        int result = proposal.solution(input, 9);
        System.out.println(result);
    }

}
