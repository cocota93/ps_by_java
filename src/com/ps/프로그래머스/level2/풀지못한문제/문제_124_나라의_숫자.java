package com.ps.프로그래머스.level2.풀지못한문제;

/*
10진법	124 나라
1	    1
2	    2
3	    4
4	    11
5	    12



6       14
7       21
8       22

9       24
10      41


*/

public class 문제_124_나라의_숫자 {

    public String solution(int n) {
//        String answer = Integer.toString(n, 4).replace('3', '4').replace('0','1');
//        String answer = Integer.toString(n + (n / 4), 4);
//        String answer = Integer.toString(n + (n / 4), 4).replace('3', '4').replace('0','1');

        String answer = Integer.toString(n, 3);
        if(n % 3 == 0){
            int i = Integer.parseInt(answer, 4);
            answer = Integer.toString(n, 3);
//            answer = "" + i;
        }
        System.out.println("" + n + "(10), answer : " + answer);
        return answer;
    }

    public static void main(String[] args) {
        문제_124_나라의_숫자 proposal = new 문제_124_나라의_숫자();

        proposal.solution(1);
        proposal.solution(2);
        proposal.solution(3);
        proposal.solution(4);
        proposal.solution(5);
        proposal.solution(6);
        proposal.solution(7);
        proposal.solution(8);
        proposal.solution(9);
        proposal.solution(10);

//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println());
    }

}
