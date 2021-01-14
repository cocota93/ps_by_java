package com.ps.프로그래머스.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {


    public int solution(int[] scoville, long K) {
        long answer = 0;
        Queue<Long> queue = new PriorityQueue<>(scoville.length, Comparator.comparing(o -> o));
        for (long i : scoville) {
            queue.add(i);
       }

        for(; queue.size() != 1 && queue.peek() < K; ){
            Long sum = 0L;
            Long min = queue.poll();
            Long secondMin = queue.poll();

            secondMin *= 2;
            sum = min + secondMin;
            queue.add(sum);
            answer += 1;
        }

        if(queue.peek() < K){
            answer = -1;
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        더맵게 proposal = new 더맵게();

        int result = proposal.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println(result);
    }

}
