package com.ps.프로그래머스.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 음양더하기 {

    public int solution(int[] absolutes, boolean[] signs) {
        int plusSum = 0;
        int minusSum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if(signs[i]){
                plusSum += absolutes[i];
            }else{
                minusSum += absolutes[i];
            }
        }

        return plusSum - minusSum;
    }

    public static void main(String[] args) throws Exception {
        음양더하기 proposal = new 음양더하기();

        /*디버깅용 입출력 */
//        System.setIn(new FileInputStream("src/com/ps/프로그래머스/level1/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");
//        int a = Integer.parseInt(st.nextToken());
//        System.out.println(a);

        int input[] = {1, 2, 3, 4};
//        proposal.solution(input);
    }

}
