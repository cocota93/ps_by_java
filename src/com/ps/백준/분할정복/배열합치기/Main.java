package com.ps.백준.분할정복.배열합치기;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/분할정복/배열합치기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int arr1[] = new int[Integer.parseInt(st.nextToken())];
        int arr2[] = new int[Integer.parseInt(st.nextToken())];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int[] mergeArr = Arrays.copyOf(arr1, arr1.length + arr2.length);
        for (int i = arr1.length; i < mergeArr.length; i++) {
            mergeArr[i] = arr2[i - (arr1.length)];
        }


//        int mergeArr[] = new int[arr1.length + arr2.length];
//        {
//            int k = 0;
//
//            for (int j = 0; j < arr1.length; j++) {
//                mergeArr[k] = arr1[j];
//                ++k;
//            }
//            for (int j = 0; j < arr2.length; j++) {
//                mergeArr[k] = arr2[j];
//                ++k;
//            }
//        }

        Arrays.sort(mergeArr);

        for (int i = 0; i < mergeArr.length; i++) {
            bw.write( mergeArr[i] + " ");
//            System.out.printf("%d ", mergeArr[i]);
        }
        bw.flush();
        bw.close();

    }

}
