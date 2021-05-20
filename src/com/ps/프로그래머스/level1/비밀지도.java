package com.ps.프로그래머스.level1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 비밀지도 {

//    public String[] solution(int n, int[] arr1, int[] arr2) {
//        int length = arr1.length;
//        List<String> result = new ArrayList<>();
//
//        for (int i = 0; i < length; i++) {
//            int[] treasureMapArray1 = Integer.toBinaryString(arr1[i]).chars().map(Character::getNumericValue).toArray();
//            int[] treasureMapArray2 = Integer.toBinaryString(arr2[i]).chars().map(Character::getNumericValue).toArray();
//
//            int clone1[] = new int[n];
//            for (int j = 0, gap = n - treasureMapArray1.length; j < treasureMapArray1.length; j++, gap++) {
//                clone1[gap] = treasureMapArray1[j];
//            }
//            int clone2[] = new int[n];
//            for (int j = 0, gap = n - treasureMapArray2.length; j < treasureMapArray2.length; j++, gap++) {
//                clone2[gap] = treasureMapArray2[j];
//            }
//
//
////            System.out.println(Arrays.toString(clone1));
////            System.out.println(Arrays.toString(clone2));
////            System.out.println("---------");
//
//
//            StringBuilder sm = new StringBuilder();
//            for (int j = 0; j < n; j++) {
//                if(clone1[j] != 0 || clone2[j] != 0){
//                    sm.append("#");
//                }else{
//                    sm.append(" ");
//                }
//            }
//            result.add(sm.toString());
//        }
//
//
//        System.out.println(result.toString());
//        return result.toArray(new String[result.size()]);
//    }


    //다른 사람이 짠 코드인데 상당히 인상적이다. or연산자를 쓴것도 그렇고 String.format으로 부족한0을 채운것도 그렇고 replaceAll을 실제로 쓰는것도 처음봤다.
    //해설을 보니 문제의 의도는 비트연산이였다고 한다.
    //https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }

    public static void main(String[] args) {
        비밀지도 proposal = new 비밀지도();

//        int n = 5;
//        int input1[] = {9, 20, 28, 18, 11};
//        int input2[] = {30, 1, 21, 17, 28};
        int n = 6;
        int input1[] = 	{46, 33, 33 ,22, 31, 50};
        int input2[] = {27 ,56, 19, 14, 14, 10};
        String[] result = proposal.solution(n, input1, input2);
//        System.out.println(Arrays.toString(result));
    }

}
