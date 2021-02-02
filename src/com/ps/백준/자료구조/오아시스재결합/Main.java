package com.ps.백준.자료구조.오아시스재결합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/자료구조/오아시스재결합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int container[] = new int[n];
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            container[i] = height;
        }


        int coupleCount = 0;
        for (int i = 0; i < container.length; i++) {
            int startHeight = container[i];
            int midHeight = 0;

            for (int j = i + 1; j < container.length; j++) {
                if(midHeight > container[j]){
                    //중간에 가로막는게 있음.
                    break;
                }

                if(container[j] > startHeight){
                    //시작한 사람 키보다 크기 떄문에 여기부터는 더이상 못봄
//                    System.out.println("left : " + i + ", right : " + j);
//                    System.out.println("left : " + container[i] + ", right : " + container[j]);
                    coupleCount++;
                    break;
                }

//                System.out.println("left : " + i + ", right : " + j);
//                System.out.println("left : " + container[i] + ", right : " + container[j]);
                coupleCount++;
                midHeight = Math.max(midHeight,container[j]);


            }
        }

        System.out.println(coupleCount);
    }

}
