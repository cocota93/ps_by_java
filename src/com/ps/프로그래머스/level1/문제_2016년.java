package com.ps.프로그래머스.level1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

/*
* 2016년 1월 1일은 금요일
* 2016년 a월 b일은 무슨요일?
* ex ) a = 5, b = 24 이면 5월24일은 화요일
* 2016년은 윤년
* 윤년 : 양력으로 4년에 한번씩 2월 29일이 있는 년도.
*
* 한달이 몇일인지 구하는 방법 : https://m.blog.naver.com/PostView.nhn?blogId=toimeme&logNo=110186020622&proxyReferer=https:%2F%2Fwww.google.com%2F
* 31일까지 : 1, 3, 5, 7, 8, 10, 12
* 30일까지 : 4, 6, 9, 11
* 28일까지(윤년에는 29일까지) : 2
*
*
* 위에꺼 다 필요없고 그냥 LocalDate라이브러리에서 제공해주네;;
* */

public class 문제_2016년 {

    public String solution(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().toString();
    }

    public static void main(String[] args) {
        문제_2016년 proposal = new 문제_2016년();

        int a = 5;
        int b = 24;

        String result = proposal.solution(a, b);
        System.out.println(result);
    }

}
