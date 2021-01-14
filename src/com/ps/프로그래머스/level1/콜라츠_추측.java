package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 콜라츠_추측 {

//    public int solution(long num) {
//        int count = 0;
//
//        for(;num != 1;){
//            if(num % 2 == 0){
//                num /= 2;
//            }else{
//                num = (num * 3) + 1;
//            }
//
//            count++;
//            if(count > 500){
//                return -1;
//            }
//        }
//
//        System.out.println(num);
//        return count;
//    }


//  다른 사람이 풀었던 풀이인데 이게 훨씬 깔끔한것 같다.
//  종료조건이 다 위에ㅁ로려있어서 깔끔.
    public int solution(long num) {
        int count = 0;

        for(;count < 500; ++count){
            if(num == 1){
                return count;
            }

            if(num % 2 == 0){
                num /= 2;
            }else{
                num = (num * 3) + 1;
            }
        }

        return -1;
    }



    public static void main(String[] args) {
        콜라츠_추측 proposal = new 콜라츠_추측();

        int result = proposal.solution(626331);
        System.out.println(result);
    }

}
