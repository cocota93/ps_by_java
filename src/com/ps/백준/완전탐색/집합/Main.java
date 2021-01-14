package com.ps.백준.완전탐색.집합;

import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/집합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int board[] = new int[20 + 1];
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int target = 0;
            if(!"all".equals(command) && !"empty".equals(command)){
                target = Integer.parseInt(st.nextToken());
            }

            if("add".equals(command)){
                board[target] = 1;
                continue;
            }
            if("remove".equals(command)){
                board[target] = 0;

                continue;
            }
            if("check".equals(command)){
                bw.write(board[target] + "\n");
                continue;
            }
            if("toggle".equals(command)){
                if(board[target] == 1){
                    board[target] = 0;
                }else{
                    board[target] = 1;
                }
                continue;
            }
            if("all".equals(command)){
                Arrays.fill(board, 1);
                continue;
            }
            if("empty".equals(command)){
                Arrays.fill(board, 0);
                continue;
            }
        }


        bw.close();
    }

}
