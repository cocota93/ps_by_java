package com.ps.백준.완전탐색.DSLR;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/DSLR/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TMAX = Integer.parseInt(br.readLine());

        for (int t = 0; t < TMAX; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startNumber = Integer.parseInt(st.nextToken());
            int destNumber = Integer.parseInt(st.nextToken());


            boolean visited[] = new boolean[10000];
            String commandHistory[] = new String[10000];
            commandHistory[startNumber] = "";

            Queue<Integer> commandQueue = new LinkedList<>();
            commandQueue.add(startNumber);
            visited[startNumber] = true;

            while (!commandQueue.isEmpty()) {
                Integer calNumber = commandQueue.poll();
                String calNumberString = String.valueOf(calNumber);

                //D
                int resultD = (calNumber * 2) % 10000;
                if (visited[resultD] == false || commandHistory[resultD].length() > commandHistory[calNumber].length() + 1) {
                    commandHistory[resultD] = commandHistory[calNumber] + "D";
                    commandQueue.add(resultD);
                    visited[resultD] = true;
                }

                //S
                int resultS = calNumber - 1;
                if (resultS <= 0) resultS = 9999;
                if (visited[resultS] == false || commandHistory[resultS].length() > commandHistory[calNumber].length() + 1) {
                    commandHistory[resultS] = commandHistory[calNumber] + "S";
                    commandQueue.add(resultS);
                    visited[resultS] = true;
                }

                //L
                int resultL;
                {
                    if(calNumberString.length() >= 2){
                        StringBuilder sb = new StringBuilder();
                        sb.append(calNumberString.substring(1));
                        sb.append(calNumberString.charAt(0));

                        resultL = Integer.parseInt(sb.toString());
                    }else{
                        resultL = calNumber;
                    }
                }

                if (visited[resultL] == false || commandHistory[resultL].length() > commandHistory[calNumber].length() + 1) {
                    commandHistory[resultL] = commandHistory[calNumber] + "L";
                    commandQueue.add(resultL);
                    visited[resultL] = true;
                }


                //R
                int resultR;
                {
                    if(calNumberString.length() >= 2){
                        StringBuilder sb = new StringBuilder();
                        sb.append(calNumberString.charAt(calNumberString.length() - 1));
                        sb.append(calNumberString.substring(0, calNumberString.length() - 1));

                        resultR = Integer.parseInt(sb.toString());
                    }else{
                        resultR = calNumber;
                    }
                }

                if (visited[resultR] == false || commandHistory[resultR].length() > commandHistory[calNumber].length() + 1) {
                    commandHistory[resultR] = commandHistory[calNumber] + "R";
                    commandQueue.add(resultR);
                    visited[resultR] = true;
                }

            }


            System.out.println(commandHistory[destNumber]);
        }

    }

}
