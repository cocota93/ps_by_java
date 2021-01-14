package com.ps.프로그래머스.level1;

import java.util.Arrays;
import java.util.Scanner;

public class 직사각형_별찍기 {


    public void solution() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        직사각형_별찍기 proposal = new 직사각형_별찍기();

        proposal.solution();
    }

}
