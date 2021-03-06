package com.ps.백준.투포인터.겹치는건싫어;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 일단 문제를 풀기전 생각나는 방법은 각 인덱스를 시작으로 연속되는 숫자가 k개를 초과할떄까지
* 카운팅해보는것이다.
* n이 최대 20만
* k가 최대 100이라
* 20만 * 100 = 2천만
* 제한시간인 1초안에 충분히 가능할것같다.
*
* 두번째로 생각나는건 이전에 풀었던 구간의 합 구하기와 비슷하다.
* 각 인덱스에 그전까지 나왔었던 숫자들의 누적된 카운트 수를 적어두고
* 그걸 기반으로 '나머지 나왔던 숫자들의 카운팅 = 누적된 숫자들의 카운팅 - 구간에서 나왔던 숫자들의 카운팅'
* 하여 계산하는것. 근데 이렇게하면 n^2 이라 제한시간 초과삘이다.
*
* 일단 첫번째 방법 시도해보자.
* -> 첫번쨰 방법 시간초과
* */

/*
* 다른사람들의 풀이를 보니
* 중복된 숫자가 k가 될떄까지 구간의 범위를 구한뒤
* k가 되면 앞에서 구간을 줄이고
* 다시 k가 줄어들경우 뒤에 구간을 늘리는 방식으로 해서 답을 구하라고 설명하고 있다.
* 전형적인 투포인터 모양이긴 한데...
* 그렇게 했을떄 최대 구간이 나온다는게 직관적으로 와닿지가 않는다.
* -> 중복된 숫자의 수에 여유가 생길떄마다 최장거리를 구한다고 이해하면 될것 같다
* -> 이렇게 함으로써 최장거리를 구하기 위해 매번 중간부분을 덧셈 해봐야 했던 부분을 스킵하고 일부구간만 더해보면 알수 있게되네
* */


class Main {

    static int n;//전체 구간의 길이
    static int k;//구간에 있는 같은정수가 k개를 초과하면 안된다.

    static int board[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/투포인터/겹치는건싫어/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        board = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < board.length; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }


        int answer = 0;

        int left = 0;
        int right = 0;
        int rangeLength = 0;
        int overlappedCheck[] = new int[100000 + 1];

        while(left <= right && right < board.length){
            if(overlappedCheck[board[right]] < k){

                overlappedCheck[board[right]]++;
                rangeLength++;
                right++;

                if(rangeLength > answer){
                    answer = rangeLength;
                }
            }else {
                overlappedCheck[board[left]]--;
                left++;
                rangeLength--;
            }

        }

        System.out.println(answer);



//        for (int startIdx = 0; startIdx < board.length; startIdx++) {
//            int rangeLength = 0;
//            int overlappedCheck[] = new int[board.length];
//
//            for (int i = startIdx; i < board.length; i++) {
//                overlappedCheck[board[i]]++;
//
//                if(overlappedCheck[board[i]] > k){
//                    break;
//                }
//
//                rangeLength++;
//            }
//
//            if(answer < rangeLength){
//                answer = rangeLength;
//            }
//        }


//        System.out.println(answer);
    }

}
