package com.ps.프로그래머스.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class 신규아이디_추천 {

    public String solution(String new_id) {
        boolean valid = checkValidID(new_id);
        if(valid) return new_id;

        //1
        String answer = new_id.toLowerCase();

        //2
        answer = answer.replaceAll("[^a-z0-9-_\\.]", "");

        //3
        answer = answer.replaceAll("\\.{2,}",".");

        //4
        answer = answer.replaceAll("^\\.|\\.$", "");

        //5
        if(answer.isEmpty()){
            answer = "a";
        }

        //6
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length() - 1) == '.'){
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        //7
        if(answer.length() <= 2){
            int needMoreAppend = 3 - answer.length();
            for (int i = 0; i < needMoreAppend; i++) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }

    public boolean checkValidID(String id){
        /*
        * 아이디의 길이는 3자 이상 15자 이하여야 합니다.
            아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
            단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
        * */
        int length = id.length();
        if(length < 3 || length > 15) return false;

        if(id.charAt(0) == '.' || id.charAt(id.length() - 1) == '.') return false;
        if(id.contains("..")) return false;

        Pattern compile = Pattern.compile("[^a-z0-9-_\\.]");
        Matcher matcher = compile.matcher(id);
        if(matcher.find()){
            return false;
        }


        char[] chars = id.toCharArray();
        for (char aChar : chars) {
            if(aChar != '.' &&
                    aChar != '_' &&
                    aChar != '-' &&
                    !Character.isDigit(aChar) &&
                    !Character.isUpperCase(aChar) &&
                    !Character.isLowerCase(aChar)
            ){
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) throws Exception {
        신규아이디_추천 proposal = new 신규아이디_추천();

        /*디버깅용 입출력 */
//        System.setIn(new FileInputStream("src/com/ps/프로그래머스/level1/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");
//        int a = Integer.parseInt(st.nextToken());
//        System.out.println(a);

        String solution = proposal.solution("!@BaT#*.y.a");
//        String solution = proposal.solution("abcd");
//        System.out.println();
    }

}
