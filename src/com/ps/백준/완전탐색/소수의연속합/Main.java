package com.ps.백준.완전탐색.소수의연속합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;



/*
* 일단 소수의 리스트를 어디간에 기록해놔야할듯하구
* 투포인터를 이용해서 합을 구해보고
* 만약 구간의 길이가 1일때도 주어진 n보다 크면 더이상구할수있는게 없다고 판단하면 될듯.
* */

/*
* 시간초과 발생하네? 이렇게가 아닌가?
* -> 찾아보니까 소수구할떄 '에라토스테네스의 체'를 사용하지 않으면 시간초과 발생하는듯함.
* */



class Main {

    static List<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/소수의연속합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        boolean inputIsPrime = false;

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (Integer prime : primeList) {
                if (i % prime == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                primeList.add(i);
                if(i == n){
                    inputIsPrime = true;
                }
            }
        }




        if(!inputIsPrime){
            System.out.println(0);
            return;
        }




//        for (Integer integer : primeList) {
//            System.out.println(integer);
//        }

        int s = 0;
        int e = 0;
        int sum = 0;
        int answer = 0;
        while(s <= e){
            if(sum == n){
                answer++;

                sum -= primeList.get(s);
                s++;
            } else if (sum < n) {
                if(primeList.size() <= e) break;

                sum += primeList.get(e);
                e++;
            } else if (sum > n) {

                sum -= primeList.get(s);
                s++;
            }
        }

        System.out.println(answer);

    }

}
