package com.ps.샘플코드.브루트포스.순열사용.다음순열;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/샘플코드/브루트포스/순열사용/다음순열/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int board[] = new int[T];
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(st.nextToken());
            board[i] = num;
        }

        do{
            System.out.println(Arrays.toString(board));
        }while(NextPermutation(board));
    }

    private static boolean NextPermutation(int[] board) {
        //0. 오름차순으로 시작해서 내림차순으로 끝. 오름차순이면 아직 다음이 남은것.
        //1. 작은 부분 순열의 시작 인덱스 선택. 이후 로직의 기준위치.
        int i = board.length - 1;
        while(i > 0 && board[i - 1] >= board[i] ) --i;

        if(i == 0) return false;

        //2. 기준위치의 앞 숫자를 무엇으로 바꿀것인지 탐색. 순열이 진행될수록 더 큰숫자로 바뀌어야 하니 더 큰숫자를 찾는다.
        int j = board.length - 1;
        while(board[i - 1] >= board[j]) --j;

        //3. 작은 부분순열의 바로앞 숫자가 더 크게 바뀜으로써 새로운 부분순열의 시작되도록 스왑
        Swap(board, i - 1, j);

        //4. 작은 부분순열이 내림차순으로 정렬된 상태이니 양끝을 계속해서 스왑하면 오름차순으로 변하여 부분수열이 시작상태가 됨.
        int k = board.length - 1;
        while(i < k){
            Swap(board, i, k);
            k--;
            i++;
        }

        return true;
    }

    private static void Swap(int[] board, int i, int j) {
        int temp = board[i];
        board[i] = board[j];
        board[j] = temp;
    }
}
