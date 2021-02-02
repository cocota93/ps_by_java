package com.ps.백준.자료구조.최소힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/자료구조/최소힙/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;



        PriorityQueue<Long> pq = new PriorityQueue<>();
        int commandCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandCount; i++) {
            long command = Long.parseLong(br.readLine());

            if(command == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    Long poll = pq.poll();
                    System.out.println(poll);
                }
            }else{
                pq.add(command);
            }
        }

    }

}
