package com.ps.프로그래머스.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class 튜플 {

    public int[] solution(String s) {
        Matcher parsingNumber = Pattern.compile("\\d+").matcher(s);
        Map<Integer, Integer> numberCountingMap = new HashMap<>();
        while(parsingNumber.find()){
            int number = Integer.parseInt(parsingNumber.group());
            numberCountingMap.put(number, numberCountingMap.getOrDefault(number,0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(numberCountingMap.entrySet());
        entries.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        int[] answer = entries.stream().mapToInt(entry -> entry.getKey()).toArray();

        return answer;
    }


    public static void main(String[] args) throws Exception {
        튜플 proposal = new 튜플();

        /*디버깅용 입출력 */
//        System.setIn(new FileInputStream("src/com/ps/프로그래머스/level2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");
//        int a = Integer.parseInt(st.nextToken());
//        System.out.println(a);

        proposal.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }

}
