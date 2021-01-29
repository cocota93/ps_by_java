package com.ps.백준.분할정복.Z;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


class Main {

    static int sequence = 0;
    static int destR;
    static int destC;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/분할정복/Z/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        destR = Integer.parseInt(st.nextToken());
        destC = Integer.parseInt(st.nextToken());

        int sideLength = (int) Math.pow(2, N);
        int baseRow = 0;
        int baseCol = 0;
        Recur(sideLength, baseRow, baseCol);


        bw.write("" + sequence);
        bw.flush();
        bw.close();

    }

    private static boolean Recur(int sideLength, int baseRow, int baseCol) {
        if(sideLength == 1){
            if(baseRow == destR && baseCol == destC){
//                System.out.println(sequence);
                return true;
            }

//            System.out.println("R : " + baseRow + ", C : " + baseCol + ", sequence : " + sequence);
            sequence++;

            return false;
        }


        int nextSideLength = sideLength / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int relativeRow = baseRow + (i * nextSideLength);
                int relativeCol = baseCol + (j * nextSideLength);
                boolean answerFind = Recur(nextSideLength, relativeRow, relativeCol);
                if(answerFind) return true;
            }
        }

        return false;
    }

}
