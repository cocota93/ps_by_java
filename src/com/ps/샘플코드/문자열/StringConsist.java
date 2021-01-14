package com.ps.샘플코드.문자열;

import java.util.Arrays;


/**
 * String : String + 연산 이나 Concat을 사용하면 새로운 String객체를 new로 만듬
 * StringBuffer : 쓰레드 세이프
 * StringBuilder : 쓰레드 세이프하지 않음. 대신 단일 쓰레드에서는 StringBuffer보다 빠름. 강사님은 StringBuilder를 더 자주 사용한다고 하심
 * */
public class StringConsist {


    public String solution(String input, int k) {
        String result = "";
        String convertedInput = "";
        convertedInput = input.replaceAll("-", "");
        convertedInput = convertedInput.toUpperCase();

        StringBuilder sb = new StringBuilder(convertedInput);

        for (int i = k; i <= convertedInput.length() ; i = i + k) {
            sb.insert(convertedInput.length() - i, "-");
        }

        result = sb.toString();
        return result;
    }

    public static void main(String[] args) {
        StringConsist proposal = new StringConsist();

//        String input = "8F3Z-2e-9-w";
        String input = "8-5g-3-J";
        int k = 4;
        String result = proposal.solution(input, k);
        System.out.println(result);
    }

}
