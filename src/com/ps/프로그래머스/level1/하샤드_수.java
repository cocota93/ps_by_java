package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 하샤드_수 {


    public boolean solution(int x) {
        int sum = String.valueOf(x).chars().map(Character::getNumericValue).sum();
        return x % sum == 0;
    }

    public static void main(String[] args) {
        하샤드_수 proposal = new 하샤드_수();

        proposal.solution(10);
    }

}
