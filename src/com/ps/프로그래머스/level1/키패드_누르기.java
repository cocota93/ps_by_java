package com.ps.프로그래머스.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 키패드_누르기 {

    class Pos{
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public String solution(int[] numbers, String hand) {
        Map<Integer, Pos> keypadPos = new HashMap<>();
        {
            for (int i = 1, x = 0, y = 0; i <= 9; i++) {
                keypadPos.put(i, new Pos(y, x));
                x++;
                if(x % 3 == 0){
                    y++;
                    x = 0;
                }
            }
            keypadPos.put(0, new Pos(3, 1));
        }

        Pos leftPos = new Pos(3, 0);
        Pos rightPos = new Pos(3, 2);
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            int destValue = numbers[i];
            Pos destPos = keypadPos.get(destValue);

            if(destValue == 1 || destValue == 4 || destValue == 7){
                resultBuilder.append("L");
                leftPos = destPos;
            }else if(destValue == 3 || destValue == 6 || destValue == 9){
                resultBuilder.append("R");
                rightPos = destPos;
            }else{
                //맨하탄 거리인지, 유클리드 거리인지에 따라서 값이 달라짐. ex) left 4번, right 8번, targetValue 2번일때.
//                double leftDistance = Math.sqrt(Math.pow(destPos.x - leftPos.x, 2) + Math.pow(destPos.y - leftPos.y, 2));
//                double rightDistance = Math.sqrt(Math.pow(destPos.x - rightPos.x, 2) + Math.pow(destPos.y - rightPos.y, 2));
                double leftDistance = Math.abs(destPos.x - leftPos.x) + Math.abs(destPos.y - leftPos.y);
                double rightDistance =Math.abs(destPos.x - rightPos.x) + Math.abs(destPos.y - rightPos.y);

                if(leftDistance < rightDistance){
                    resultBuilder.append("L");
                    leftPos = destPos;
                }else if(leftDistance > rightDistance){
                    resultBuilder.append("R");
                    rightPos = destPos;
                }else{
                    if("left".equals(hand)){
                        resultBuilder.append("L");
                        leftPos = destPos;
                    }else{
                        resultBuilder.append("R");
                        rightPos = destPos;
                    }
                }
            }
        }

        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        키패드_누르기 proposal = new 키패드_누르기();

        int numbers[] = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "right";
        String result = proposal.solution(numbers, hand);
        System.out.println(result);
    }

}
