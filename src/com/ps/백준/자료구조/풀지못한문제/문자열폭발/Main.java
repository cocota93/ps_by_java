package com.ps.백준.자료구조.풀지못한문제.문자열폭발;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
* 그냥 문자열 포함되어있는지 체크하고 계속 조인해주면 되는거 아닌가? 왜 골드4 로 분류되어있는거지??
* -> 제출했더니 메모리초과;;문자열의 길이는 최대 백만. 문자 하나에 2바이트씩 먹는다고 계산해도 1.9메가라서 괜찮지않나?
* -> 스택 기본크기 초과한듯.
* -> 어떠카지
*
* */

/*
* 풀이 보니까 이해는 가는데...나중에 다시 풀어봐야겠다.
* */


class Main {
//    static String destStr;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/자료구조/문자열폭발/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String destStr = br.readLine();
        String explosionStr = br.readLine();


        while(true){
            int explosionStartIdx = destStr.indexOf(explosionStr);
            if(explosionStartIdx == -1) break;

            destStr = destStr.substring(0, explosionStartIdx) + destStr.substring(explosionStartIdx + explosionStr.length());
        }


        if(destStr.length() == 0){
            destStr = "FRULA";
        }

        System.out.println(destStr);
    }

}
