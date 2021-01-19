package com.ps.백준.완전탐색.수열의순서;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

//첫번쨰 시도...시간초과...고민해보다가 백준 질문검색 게시판 보니 NextPermutation은 n!라서 안된다는 글 봄. 해결방법은 안봄
//NextPermutation 말고 다른걸 구현하던가 어떤 규칙을 파악해서 중간을 건너뛰고 시작해야할것 같은데..
//아까 구현해보다가 실패한 재귀로 하는 방법을 다시 시도 해봐야 겠다.
//두번째 시도...재귀로 구현시도...실패...해답보러...규칙을 파악해서 중간을 건너뛰는게 포인트였다. 이것도 해볼껄 ㅎㅎ;;
//세번쨰 시도...중간을 건너 뛰고 시작해봤지만 시간초과...ㅡㅡ

//풀이 출처 : https://it-earth.tistory.com/115
//https://wjdgus2951.tistory.com/66

class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/수열의순서/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine()," ");
        int type = Integer.parseInt(st.nextToken());

        long preCaledFactorial[] = new long[21];
        for (int i = 0; i < preCaledFactorial.length; i++) {
            preCaledFactorial[i] = Factorial(i);
        }

        if(type == 1){
            int kCount = Integer.parseInt(st.nextToken());//k번쨰 수열
            List<Integer> result = new ArrayList<>();

            boolean usedNumber[] = new boolean[21];

            for (int orderDigit = 1; orderDigit <= n; orderDigit++) {
                for (int useNumberIdx = 1; useNumberIdx <= n; useNumberIdx++) {
                    if(usedNumber[useNumberIdx] == true) continue;

                    if(preCaledFactorial[n - orderDigit] < kCount){
                        kCount -= preCaledFactorial[n - orderDigit];
                    }else{
                        result.add(useNumberIdx);
                        usedNumber[useNumberIdx] = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < result.size(); i++) {
                System.out.printf("%d ", result.get(i));
            }
        }else if(type == 2){
            //입력으로 준 숫자가 몇번쨰 수열인지
            int inputPermutation[] = new int[n];
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                inputPermutation[i] = num;
            }

            boolean usedNumber[] = new boolean[21];

            long resultK = 0;
            for (int orderDigit = 0; orderDigit < inputPermutation.length; orderDigit++) {
                for (int useNumber = 1; useNumber < inputPermutation[orderDigit]; useNumber++) {
                    if(usedNumber[useNumber] == true) continue;
                    resultK += preCaledFactorial[inputPermutation.length - orderDigit - 1];
                    //dest.length - destOrdinal - 1 요 계산이
                    //각 자릿수의 F(n) = n * F(n - 1)를 계산할때 F(n - 1)을 의미한다는걸 더 이해하기 쉽게 표현하고싶은데...
                }

                usedNumber[inputPermutation[orderDigit]] = true;
            }

            System.out.println(resultK + 1);
        }

    }

    private static long Factorial(int i) {
        long result = 1;
        for (int j = i; j >= 2; j--) {
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
