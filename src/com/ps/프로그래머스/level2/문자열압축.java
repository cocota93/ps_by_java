package com.ps.프로그래머스.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* abcabcabc라는 문자열이었다면 3abc가 가장 짧겠지만
* abc라는 문자열이였다면 그냥 abc가 가장 짦음.
* 그러므로 단순히 어떤 공식같은걸로는 알기 힘들것같음.
* 그렇다면 완탐?
*
* (전체문자열의 길이 / 자르는 문자열의 길이) + 1
* 이런느낌으로 할수도 있지않을까? 하지만 이렇게해도 결국 완탐처럼 다 해봐야겠네?
*
*
* */

public class 문자열압축 {

    public int solution(String s) {
        int answer = s.length();

        for (int cutLength = 1; cutLength < s.length(); cutLength++) {
//            \Gabc+


            int packingLength = 0;
            for (int i = 0; i < s.length();) {
                String shortString = s.substring(i, Math.min(s.length(), i + cutLength));
                String longString = s.substring(i);

                Matcher matcher = Pattern.compile("\\G" + shortString).matcher(longString);
                long sequenceMatchCount = matcher.results().count();

                if(sequenceMatchCount > 1){
                    packingLength += String.valueOf(sequenceMatchCount).length() + shortString.length();
                }else {
                    packingLength += shortString.length();
                }

                i += (shortString.length() * sequenceMatchCount);
            }

            if(answer > packingLength){
                answer = packingLength;
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) throws Exception {
        문자열압축 proposal = new 문자열압축();

        /*디버깅용 입출력 */
//        System.setIn(new FileInputStream("src/com/ps/프로그래머스/level2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");
//        int a = Integer.parseInt(st.nextToken());
//        System.out.println(a);

        proposal.solution("aabbaccc");
    }

}
