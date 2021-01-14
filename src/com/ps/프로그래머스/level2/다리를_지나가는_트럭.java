package com.ps.프로그래머스.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다리를_지나가는_트럭 {

    public int solution(int bridge_length/*트럭이 다리를 지나는데 걸리는 시간*/, int weight_limit, int[] truck_weights) {
        int passTruckCount = 0;
        int driveTruckIdx = 0;
        int totalSecond = 0 ;
        int currentWeight = 0;
        Map<Integer, Integer> eachSecond = new HashMap<>();

        for (totalSecond = 1; passTruckCount < truck_weights.length; totalSecond++){
            if(driveTruckIdx < truck_weights.length
                    && truck_weights[driveTruckIdx] + currentWeight <= weight_limit){
                currentWeight += truck_weights[driveTruckIdx];
                eachSecond.put(driveTruckIdx, 0);
                ++driveTruckIdx;
            }

            for (Map.Entry<Integer, Integer> entrySet : eachSecond.entrySet()) {
                Integer key = entrySet.getKey();

                if(entrySet.getValue() < bridge_length){
                    entrySet.setValue(entrySet.getValue() + 1);
                }
                if(entrySet.getValue() == bridge_length){
                    passTruckCount++;
                    currentWeight -= truck_weights[key];
                    entrySet.setValue(entrySet.getValue() + 1);
                }
            }


        }

        System.out.println(totalSecond);
        

        return totalSecond;
    }

    public static void main(String[] args) {
        다리를_지나가는_트럭 proposal = new 다리를_지나가는_트럭();

        proposal.solution(2,  10, new int[]{7,4,5,6});
    }

}
