package com.ps.백준.완전탐색.다음순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    //fail
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/다음순열/input.txt"));
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

        if(CheckSorted(board)){
            System.out.printf("-1");
            return;
        }

        boolean morePermutation = NextPermutation(board);
//        if(!morePermutation){
//            System.out.printf("-1");
//            return;
//        }

        for (int i = 0; i < board.length; i++) {
            System.out.printf("%d ", board[i]);
        }
    }

    private static boolean NextPermutation(int[] board) {

/*
        [1, 2, 3, 4]
        [1, 2, 4, 3]
        [1, 3, 2, 4]
        [1, 3, 4, 2]
        [1, 4, 2, 3]
        [1, 4, 3, 2]
        [2, 1, 3, 4]
        [2, 1, 4, 3]
        [2, 3, 1, 4]
        [2, 3, 4, 1]
        [2, 4, 1, 3]
        [2, 4, 3, 1]
        [3, 1, 2, 4]
        [3, 1, 4, 2]
        [3, 2, 1, 4]
        [3, 2, 4, 1]
        [3, 4, 1, 2]
        [3, 4, 2, 1]
        [4, 1, 2, 3]
        [4, 1, 3, 2]
        [4, 2, 1, 3]
        [4, 2, 3, 1]
        [4, 3, 1, 2]
        [4, 3, 2, 1]
* */

/*
* 로직 따라가면 '아 이래서 이렇구나' 하기는 하지만
* 규칙에대해서 제대로 명확하게 설명을 못하기 떄문에
*
* 왜 while(i > 0 && board[i - 1] >= board[i]) i--; 요런 로직이 필요한건지
* while(board[i - 1] >= board[j]) --j; 왜 요런 로직이 필요한지 제대로 이해가 안감.
* */

/*
* 1. 순열의 처음 시작은 오름차순으로 시작한다.
* 2. 순열의 모든 부분이 내림차순이 되면 순열은 끝이난것이다.
*
* 1. 배열의 오른쪽 끝에서부터 바로 왼쪽의 인덱스와 비교하였을때 오름차순으로 정렬된 인덱스를 찾는다. 찾았다면 그곳이 다음 순열조합을 만들기 위한 기점이 되는 위치이다.
* 2. 오름차순을 내림차순으로 바꿔야 하기 때문에 1번에서 찾은 값보다 더 큰값을 찾아야 한다. 오른쪽 끝에서부터 탐색하여 해당 위치를 찾는다.
* 3. 1번과 2번에서 찾은 두 값을 스왑. 부분적으로 내림차순이 만들어짐.
* 4. 내림차순으로 정렬된 일부 구간의 양끝을 교환함으로써 오름차순으로 변환
* */

//https://sangwoo0727.github.io/algorithm/Algorithm-nextPermu/


        int i = board.length - 1;
        while(i > 0 && board[i - 1] >= board[i]) i--;//내림차순으로 바꿀 위치 탐색. i는 내림차순으로 바꿀 위치의 인덱스

        if(i <= 0) return false;

        int j = board.length - 1;
        while(board[i - 1] >= board[j]) --j;


        Swap(board, i - 1, j);


        int k = board.length - 1;
        while(i < k){//내림차순으로 정렬된 일부 구간의 양끝을 교환함으로써 오름차순으로 변환
            Swap(board, i, k);
            i++;
            k--;
        }

//        System.out.println(Arrays.toString(board));
        return true;
    }

    private static void Swap(int[] board, int i, int j) {
        int temp = board[i];
        board[i] = board[j];
        board[j] = temp;
    }

    private static boolean CheckSorted(int[] board) {
        int prev = board[0];
        for (int i = 1; i < board.length; i++) {
            if(prev < board[i]) return false;
            else prev = board[i];
        }

        return true;
    }

}
