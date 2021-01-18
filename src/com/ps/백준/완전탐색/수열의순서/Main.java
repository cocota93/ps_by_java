package com.ps.백준.완전탐색.수열의순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//첫번쨰 시도...시간초과...고민해보다가 백준 질문검색 게시판 보니 NextPermutation은 n!라서 안된다는 글 봄. 해결방법은 안봄
//NextPermutation 말고 다른걸 구현하던가 어떤 규칙을 파악해서 중간을 건너뛰고 시작해야할것 같은데..
//아까 구현해보다가 실패한 재귀로 하는 방법을 다시 시도 해봐야 겠다.
//두번째 시도...재귀로 구현시도...실패...해답보러...규칙을 파악해서 중간을 건너뛰는게 포인트였다. 이것도 해볼껄 ㅎㅎ;;
//세번쨰 시도...중간을 건너 뛰고 시작해봤지만 시간초과...ㅡㅡ

//풀이 출처 : https://dundung.tistory.com/60


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/수열의순서/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine()," ");
        int type = Integer.parseInt(st.nextToken());

        if(type == 1){
            int board[] = new int[n];

            int kCount = Integer.parseInt(st.nextToken());//k번쨰 수열

            int range = Factorial(n - 1);
            for (int i = 1; i <= n; i++) {
                int rangeEnd = range * i;
                if(kCount < rangeEnd){
                    board[0] = i;
                    Queue<Integer> queue = new LinkedList<>();
                    for (int j = 0; j < board.length; j++) {
                        if(j + 1 == i) continue;
                        queue.add(j + 1);
                    }
                    for (int j = 1; j < board.length; j++) {
                        board[j] = queue.poll();
                    }
                    break;
                }
            }


            if(kCount == 0){
                System.out.println(Arrays.toString(board));
                return;
            }else{
                for (int i = 1; i < kCount; i++) {
                    NextPermutation(board);
                }
                Arrays.stream(board).forEach(number -> System.out.printf("%d ", number));
                return;
            }
        }else if(type == 2){
            //몇번쨰 수열인지


            int destAnswer[] = new int[n];
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                destAnswer[i] = num;
            }

            int board[] = new int[n];
            if(destAnswer[0] == 1){
                for (int i = 0; i < board.length; i++) {
                    board[i] = i + 1;
                }
            }else{
                board[0] = destAnswer[0];
                Queue<Integer> queue = new LinkedList<>();
                for (int j = 0; j < board.length; j++) {
                    if(j + 1 == board[0]) continue;
                    queue.add(j + 1);
                }
                for (int j = 1; j < board.length; j++) {
                    board[j] = queue.poll();
                }

            }

            int range = Factorial(n - 1);
            int skipCount = range * (board[0] - 1);
            int count = 1 + skipCount;
            if(Arrays.equals(board, destAnswer)){
                System.out.println(count);
                return;
            }

            while(true){
                boolean hasNext = NextPermutation(board);
                count++;
                if(Arrays.equals(board, destAnswer)){
                    System.out.println(count);
                    return;
                }

                if(!hasNext){
                    return;
                }
            }

        }
    }

    private static int Factorial(int i) {
        int result = 1;
        for (int j = i - 1; j >= 2; j--) {
            result *= j;
        }
        return result;
    }

    private static boolean NextPermutation(int[] board) {
        //다음순열 문제 너무 쳐다보니까 코드가 외워져버림..


        //0. 오름차순으로 시작해서 내림차순으로 끝. 오름차순이면 아직 다음이 남은것.
        //1. 작은 부분 순열의 시작 인덱스 선택. 이후 로직의 기준위치.
        int i = board.length - 1;
        while(i > 0 && board[i - 1] > board[i] ) --i;

        if(i == 0) return false;

        //2. 기준위치의 앞 숫자를 무엇으로 바꿀것인지 탐색. 순열이 진행될수록 더 큰숫자로 바뀌어야 하니 더 큰숫자를 찾는다.
        int j = board.length - 1;
        while(board[i - 1] > board[j]) --j;

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

    private static void Recur(int[] board, int depth) {

        if(depth == board.length){
            Arrays.stream(board).forEach(number -> System.out.printf("%d ", number));
            return;
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
//                Swap()
                Recur(board, depth + 1);
//                Swap()
                //재귀로도 어떻게 할수 있을것 같은데 음...그전에도 비슷한거 구현한적 있었던것 같은데 다시 할려니까 못하겠음
                //문제를 다시보다보니 반드시 연속된 숫자로 주네
            }
        }

    }

}
