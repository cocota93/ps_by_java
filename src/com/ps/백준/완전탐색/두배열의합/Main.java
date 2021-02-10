package com.ps.백준.완전탐색.두배열의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


/*
* 부분수열의합2 문제와 비슷한거 아닌가?
* 투포인터를 사용하는데 배열2개라는거
* -> 그렇게할려면 각 배열로 만들수 있는 합에 대한 리스트를 만들어서 처리해야함.
*
* */

/*
* 나올수있는 합 만들어줄떄 문제에서 부분수열이라는 언급이 없기 떄문에 연속된 합으로 해야하나보다ㅡㅡ
* */


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/두배열의합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        long t = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long A[] = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }


        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long B[] = new long[m];
        for (int i = 0; i < m; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }





        /*
        * 정렬 해주야할까?
        * 굳이 안해도 답은 나올거같은데??
        * -> 배열에 들어가는 값이 마이너스도 나올수 있어서 해줘야할듯
        * */
//        Arrays.sort(A);
//        Arrays.sort(B);

        List<Long> makedCaseSumAList = new ArrayList<>();
        {
            for (int i = 0; i < A.length; i++) {
                long sum = 0;
                for (int j = i; j < A.length; j++) {
                    sum += A[j];
                    makedCaseSumAList.add(sum);
                }
            }
        }
        makedCaseSumAList.sort(Comparator.comparingLong(Long::longValue));


        List<Long> makedCaseSumBList = new ArrayList<>();
        {
            for (int i = 0; i < B.length; i++) {
                long sum = 0;
                for (int j = i; j < B.length; j++) {
                    sum += B[j];
                    makedCaseSumBList.add(sum);
                }
            }
        }
        makedCaseSumBList.sort(Comparator.comparingLong(Long::longValue));


        long answer = 0;
        int leftIdx = 0;
        int rightIdx = makedCaseSumBList.size() - 1;
        while(leftIdx < makedCaseSumAList.size() && rightIdx >= 0){

            long leftSelectValue = makedCaseSumAList.get(leftIdx);
            long rightSelectValue = makedCaseSumBList.get(rightIdx);
            long sum = leftSelectValue + rightSelectValue;
            if(sum == t){

                long leftEqualCount = 0;
                while(leftIdx < makedCaseSumAList.size() && makedCaseSumAList.get(leftIdx) == leftSelectValue){
                    leftIdx++;
                    leftEqualCount++;
                }

                long rightEqualCount = 0;
                while(rightIdx >= 0 && makedCaseSumBList.get(rightIdx) == rightSelectValue){
                    rightIdx--;
                    rightEqualCount++;
                }


                answer += leftEqualCount * rightEqualCount;
//                leftIdx++;
            }else if(sum < t){
                leftIdx++;
            }else if(sum > t){
                rightIdx--;
            }
        }

        System.out.println(answer);

    }

    private static void makedCaseSum(List<Long> makedCaseSumList, long oldSum, int depth, long[] originContainer) {
        if (depth == originContainer.length) {
            makedCaseSumList.add(oldSum);
            return;
        }

        makedCaseSum(makedCaseSumList, oldSum, depth + 1, originContainer);
        makedCaseSum(makedCaseSumList,oldSum + originContainer[depth], depth + 1, originContainer);
    }


}
