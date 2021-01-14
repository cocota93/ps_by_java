package com.ps.인프런.stringarray;

import java.util.*;
import java.util.stream.Collectors;

public class MeetingRoom2 {

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
//        fixedInput.sort((o1, o2) -> o1.start - o2.start );
        fixedInput.sort((o1, o2) -> o1.end - o2.end );

        System.out.println("sortedInput");
        for (Interval interval : fixedInput) {
            interval.print();
        }

        Queue<Interval> minHeap = new PriorityQueue<>(fixedInput.size(), (o1, o2) -> o1.start - o2.start);


        for (Interval interval : fixedInput) {
            minHeap.add(interval);
        }


        System.out.println("minhip");
        //정렬순서 어떻게 될지 알수없음
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
        MeetingRoom2 proposal = new MeetingRoom2();

        int input[][] = {{0,30},{5,10},{15,20}};
//        int input[][] = {{0,30},{5,10},{35,20}};
//        int input[][] = {{0,30},{5,10},{15,20},{4, 60}};
//        int input[][] = {{0,30},{5,10},{35,20},{4, 60}};
        proposal.solution(input);
    }

}
