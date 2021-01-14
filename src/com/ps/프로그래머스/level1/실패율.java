package com.ps.프로그래머스.level1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 실패율 {

    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> failPercentMap = new HashMap<>();

        for(int stageLevel = 1; stageLevel <= N; ++stageLevel){
            int tryCount = 0;
            int failCount = 0;
            for (int i = 0; i < stages.length; i++) {
                if(stageLevel <= stages[i]){
                    ++tryCount;
                }
                if(stageLevel == stages[i]){
                    ++failCount;
                }
            }

            if(tryCount != 0){
                double failPercent = (double)failCount / tryCount;
                failPercentMap.put(stageLevel, failPercent);
            }else{
                failPercentMap.put(stageLevel, Double.valueOf(0));
            }
        }

        List<Map.Entry<Integer, Double>> forResultSortList = new ArrayList<>(failPercentMap.entrySet());
        forResultSortList.sort((obj1, obj2) -> {
            int compareResult = obj2.getValue().compareTo(obj1.getValue());
            if(compareResult == 0){
                return obj1.getKey().compareTo(obj2.getKey());
            }
            return compareResult;
        });

//        Stream.of(failPercentMap).sorted((obj1, obj2) -> {
//            int compareResult = obj2.getValue().compareTo(obj1.getValue());
//            if(compareResult == 0){
//                return obj1.getKey().compareTo(obj2.getKey());
//            }
//            return compareResult;
//        });

//        for (Map.Entry<Integer, Double> integerDoubleEntry : forResultSortList) {
//            System.out.println(integerDoubleEntry.getKey() + ", " + integerDoubleEntry.getValue());
//        }

        List<Integer> result = forResultSortList.stream()
                .map(obj -> obj.getKey())
                .collect(Collectors.toList());

//        Arrays.sort(failPercentMap, (o1, o2) -> o1.get)
//        failPercentMap.entrySet().

//        Arrays.stream(stages).boxed()
////                .collect(Collectors.groupingBy(obj -> obj, Collectors.counting()))
//                .collect(Collectors.groupingBy(obj -> obj, Collectors.counting()))
//                .values().stream()
////                .mapToInt(obj -> (int) (obj / N))
//                .sorted((o1, o2) -> (int) (o2 - o1))
//                .mapToInt(Long::intValue)
////                .sort
//                .toArray();

//        Map<Integer, Long> collect = Arrays.stream(stages).boxed()
////                .collect(Collectors.groupingBy(obj -> obj, Collectors.counting()))
//                .collect(Collectors.groupingBy(obj -> obj));

//        int[] result = Arrays.stream(stages).boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .values().stream()
////                .mapToInt(obj -> (int) (obj / N))
////                .sorted((o1, o2) -> (int) (o2 - o1))
//                .mapToInt(Long::intValue)
////                .sort
//                .toArray();

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        실패율 proposal = new 실패율();

        int[] result = proposal.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        System.out.println(Arrays.toString(result));
    }

}
