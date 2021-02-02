package com.ps.백준.자료구조.최대힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


//최대힙, 최소힙과 우선순위큐가 같은말인가?
//-> 우선순위큐는 개념적으로는 큐 이지만 내부적으로는 힙이라는 이진트리 형태의 구현을 가지고있음.
//이떄 어떤 우선순위를 갖느냐에 따라 최대힙, 최소힙이 갈림.

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/자료구조/최대힙/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
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
