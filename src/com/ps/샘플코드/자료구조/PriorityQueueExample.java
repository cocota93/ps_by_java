package com.ps.샘플코드.자료구조;

import com.ps.인프런.stringarray.MeetingRoom2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {


    class Interval{
        Integer start;
        Integer end;

        public Interval() {
        }

        public Interval(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        public void print(){
            System.out.println("start : " + start + ", end : " + end);
        }
    }


    public int solution(int[][] input) {
        List<Interval> fixedInput = new ArrayList<>();
        for (int[] row : input) {
            Interval interval = new Interval(row[0], row[1]);
            fixedInput.add(interval);
        }
        fixedInput.sort((o1, o2) -> o1.end - o2.end );

        System.out.println("sortedInput");
        for (Interval interval : fixedInput) {
            interval.print();
        }



//pop의 순서가 보장되는거지 이터레이터의 순서는 보장 안됨.
        Queue<Interval> minHeap = new PriorityQueue<>(fixedInput.size(), (o1, o2) -> o1.start - o2.start);
        for (Interval interval : fixedInput) {
            minHeap.add(interval);
        }

        System.out.println("minhip");
        for (Interval interval : minHeap) {
            interval.print();
        }


        //큐만들때 내가 지정한 우선순위에 맞게 뽑혀져나옴.
        System.out.println("");
        System.out.println("--------");
        minHeap.poll().print();
        minHeap.poll().print();
        minHeap.poll().print();

        return 0;
    }

    public static void main(String[] args) {
        PriorityQueueExample proposal = new PriorityQueueExample();

        int input[][] = {{0,30},{5,10},{15,20}};//이상한 예제1
//        int input[][] = {{0,30},{5,10},{35,20}};//이상한 예제2
//        int input[][] = {{0,30},{5,10},{15,20},{4, 60}};//정상 예제3
//        int input[][] = {{0,30},{5,10},{35,20},{4, 60}};//정상 예제4
        proposal.solution(input);
    }


}
