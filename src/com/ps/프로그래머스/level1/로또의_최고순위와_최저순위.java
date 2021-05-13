package com.ps.프로그래머스.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 로또의_최고순위와_최저순위 {

    public int[] solution(int[] lottos/*찍은번호*/, int[] win_nums/*실제 당첨번호*/) {
        int[] answer = {};

        int correctCount = 0;
        int missingNumCount = 0;

        for (int lotto : lottos) {
            if(lotto == 0){
                missingNumCount++;
            }
        }

        for (int win_num : win_nums) {
            for (int myNum : lottos) {
                if(win_num == myNum){
                    correctCount++;
                }
            }
        }

        int maxScore = getScore(correctCount + missingNumCount);
        int minScore = getScore(correctCount);

        answer = new int[2];
        answer[0] = maxScore;
        answer[1] = minScore;

        return answer;
    }

    private int getScore(int matchCount) {
        if(matchCount < 2){
            return 6;
        }else {
            return 7 - matchCount;
        }
    }

    public static void main(String[] args) throws Exception {
        로또의_최고순위와_최저순위 proposal = new 로또의_최고순위와_최저순위();

        /*디버깅용 입출력 */
//        System.setIn(new FileInputStream("src/com/ps/프로그래머스/level1/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");
//        int a = Integer.parseInt(st.nextToken());
//        System.out.println(a);

//        proposal.solution(nu);
    }

}
