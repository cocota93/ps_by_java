package com.ps.swea.level2.조교의_성적_매기기;

import java.util.*;
import java.io.FileInputStream;


class Solution {

    public static class People {
        int peopleNumber;
        Double totalScore;

        public People(int peopleNumber, int middleScore, int finalScore, int examScore) {
            this.peopleNumber = peopleNumber;
            this.totalScore = middleScore * 0.35 + finalScore * 0.45 + examScore * 0.2;
        }

    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level2/조교의_성적_매기기/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            List<People> peopleList = new ArrayList<>();
            int peopleSize = sc.nextInt();
            int targetNumber = sc.nextInt();
            for (int i = 0; i < peopleSize; i++) {
                People people = new People(i + 1, sc.nextInt(), sc.nextInt(), sc.nextInt());
                peopleList.add(people);
            }

            peopleList.sort((obj1, obj2) -> obj2.totalScore.compareTo(obj1.totalScore));


            System.out.printf("#%d ", test_case);
            RenderTargetScore(peopleList, targetNumber);
            System.out.printf("\n");
        }
    }

    private static void RenderTargetScore(List<People> peopleList, int targetNumber) {
        for (int i = 0; i < peopleList.size(); i++) {
            People people = peopleList.get(i);
            if(people.peopleNumber != targetNumber) continue;

            int gap = peopleList.size() / 10;
            if(i < gap * 1){
                System.out.printf("A+");
                break;
            } else if(i < gap * 2){
                System.out.printf("A0");
                break;
            } else if(i < gap * 3){
                System.out.printf("A-");
                break;
            } else if(i < gap * 4){
                System.out.printf("B+");
                break;
            } else if(i < gap * 5){
                System.out.printf("B0");
                break;
            } else if(i < gap * 6){
                System.out.printf("B-");
                break;
            } else if(i < gap * 7){
                System.out.printf("C+");
                break;
            } else if(i < gap * 8){
                System.out.printf("C0");
                break;
            } else if(i < gap * 9){
                System.out.printf("C-");
                break;
            } else{
                System.out.printf("D0");
                break;
            }
        }
    }

}
