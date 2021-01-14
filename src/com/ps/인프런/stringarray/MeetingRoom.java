package com.ps.인프런.stringarray;

import java.util.*;
import java.util.stream.Collectors;



public class MeetingRoom {

    class Interval {

        Integer start;
        Integer end;

        public Interval() {
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


    }

    public boolean solution(int[][] input) {
        List<Interval> intervalList = new ArrayList<>();

        for (int[] rows : input) {
            Interval interval = new Interval(rows[0], rows[1]);
            intervalList.add(interval);
        }

        intervalList.sort(Comparator.comparing(o -> o.start));

        Integer lastEnd = 0;
        for (Interval interval : intervalList) {
            if(interval.start <= lastEnd){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MeetingRoom proposer = new MeetingRoom();

//        int[][] input = {{0,30},{5,10},{15,20}};
        int[][] input = {{7,10},{2,4}};
        boolean result = proposer.solution(input);
        System.out.println(result);
    }
}
