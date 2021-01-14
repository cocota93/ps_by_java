package com.ps.프로그래머스.level2.풀지못한문제;

public class 삼각_달팽이 {

    public int[] solution(int n) {
        int memo[] = new int[n + 1];
        for (int i = 1; i < memo.length; i++) {
            memo[i] = (int) (Math.pow(i, 2) - memo[i - 1]);
        }


        int[] answer = {};
        return answer;
    }

    public int temp(int a, int d, int n){
        int l = a + (n - 1) * d;
        int result = n * (a + l) / 2;

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        삼각_달팽이 proposal = new 삼각_달팽이();


    }


}
