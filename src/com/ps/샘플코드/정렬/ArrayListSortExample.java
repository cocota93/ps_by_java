package com.ps.샘플코드.정렬;



import java.util.*;
import java.util.stream.Collectors;


public class ArrayListSortExample {

    class SampleInterval {

        Integer start;
        Integer end;

        public SampleInterval() {
        }

        public SampleInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Integer getStart() {
            return start;
        }

        public Integer getEnd() {
            return end;
        }
    }


    public void arrayListSolution(int[][] input) {
        List<SampleInterval> intervalList = new ArrayList<>();

        for (int[] rows : input) {
            SampleInterval interval = new SampleInterval(rows[0], rows[1]);
            intervalList.add(interval);
        }

        Collections.sort(intervalList, new Comparator<SampleInterval>(){
            @Override
            public int compare(SampleInterval o1, SampleInterval o2) {
                return o1.start - o2.start;
            }
        });
        Collections.sort(intervalList, ( o1,  o2) -> o1.start - o2.start);
        intervalList.sort((o1, o2) -> o1.start - o2.start);
        intervalList.sort(Comparator.comparing((SampleInterval o) -> o.start));
        intervalList.sort(Comparator.comparing(interval -> interval.start));

        //intStream같은 primitive를 기반으로하는 stream은 sorted만 가능하네
//IntegerStream은 reverse도 가능.

        intervalList.sort(Comparator.comparing(SampleInterval::getEnd).reversed());
//        intervalList.stream().sorted(Comparator.reverseOrder());//비교연산자 정의하면 사용 가능
//        intervalList.stream().collect(Collectors.joining())
        for (SampleInterval sampleInterval : intervalList) {
            System.out.print(sampleInterval.start + ", " + sampleInterval.end);
            System.out.println("");
        }
    }



    public void arraySolution(int[][] input) {

//        Arrays.sort(input, Collections.reverseOrder());
        Arrays.sort(input, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(input, Comparator.comparing(o -> o[0]));

        System.out.println(Arrays.deepToString(input));
    }

    public static void main(String[] args) {
        ArrayListSortExample proposer = new ArrayListSortExample();

        int[][] input = {{5,10},{0,30},{15,20}};
        proposer.arrayListSolution(input);
        proposer.arraySolution(input);
    }

}
