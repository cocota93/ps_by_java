package com.ps.샘플코드.수학;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class 약수 {


    //구하려는 값이 36이라면
    // 1 * 36, 2 * 18, 3 * 12, 4 * 9,
    // 6 * 6
    // 36  * 1, 18 * 2, 12 * 3, 9 * 4
    //위와같이 제곱근을 중심으로 조합이 반복된다.
    //떄문에 인덱스를 제곱한값이 구하려는 값 N과 같을떄까지
    //or 구하려는값 N의 제곱근까지만 약수를 확인하면 된다.

    //7의 제곱보다 1작은 48에대해 생각해보자
    //48의 약수는
    // 1 * 48, 2 * 24, 3 * 16, 4 * 12, 6 * 8
    //6까지만 계산을 돌면 나머지도 다 알수있다는게 보인다.

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level1/간단한n의약수/input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        List<Integer> result = new ArrayList<>();

        for (int i = 1; i * i <= N; i++) {
            if(N % i == 0){
                result.add(i);
                if(i*i < N){
                    result.add(N / i);
                }
            }
        }

//        int squareRoot = (int) Math.sqrt(N);
//        for (int i = 1; i <= squareRoot; i++) {
//            if (N % i == 0) {
//                result.add(i);
//                if (i * i < N) {
//                    result.add(N / i);
//                }
//            }
//        }

        result.sort(Comparator.comparingInt(Integer::intValue));

        result.forEach(value -> System.out.printf("%d ", value));
    }


}
