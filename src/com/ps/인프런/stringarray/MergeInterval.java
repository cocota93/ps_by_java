package com.ps.인프런.stringarray;

import java.util.*;

public class MergeInterval {

    class Interval{
        Integer start;
        Integer end;

        public Interval() {
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void print(){
            System.out.println("start : " + start + ", end : " + end);
        }

    }


    public List<Interval> solution(int[][] input) {

        List<Interval> sortedInput = new ArrayList<>();
        List<Interval> result = new ArrayList<>();

        for (int[] row : input) {
            Interval interval = new Interval(row[0], row[1]);
            sortedInput.add(interval);
        }
        sortedInput.sort(Comparator.comparing(o -> o.start));


        Interval before = sortedInput.get(0);
        for (int i = 1; i < sortedInput.size(); i++) {
            Interval current = sortedInput.get(i);

            if(before.end >= current.start){
                //merge
                Interval mergeInterval = new Interval(before.start, Math.max(before.end,current.end));
                before = mergeInterval;
            }else{
                result.add(before);
                before = current;
            }

        }

        if(!result.contains(before)){
            result.add(before);
        }

        return result;
    }

    public static void main(String[] args) {
        MergeInterval proposer = new MergeInterval();

        int input[][] = {{1,3},{2,6},{8,10},{15,18}};
        List<Interval> solution = proposer.solution(input);
        for (Interval interval : solution) {
//            System.out.println("start : " + interval.start + ", end : " + interval.end);
            interval.print();
        }
    }

}
