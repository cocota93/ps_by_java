package com.ps.백준.완전탐색.합이_0인_네_정수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

/*
* 시간제한이 12초나되네?
* 뭔가 새로운 기법이 필요할 삘인데
*
* */


/*
* 최대 길이가 4천까지 될수있는 A, B, C, D 배열들의 값으로 합이 0인 경우의 수를 카운팅 하는 문제.
*
* A그룹과 B그룹으로 만들수있는 값들을 만드는데 n^2 = 천육백만(각 그룹에서 한개씩만 뽑으면 되니까)
* B그룹과 C그룹으로 만들수있는 값들을 만드는데 n^2 = 천육백만
* 합하면 육천사백만
*
* 만들어진 배열들을 정렬하는데 필요한 시간복잡도 nLogn = 약 4억(여기서 n은 천육백만)
* 두개니까 8억
*
* 투포인터의 시간복잡도는 정렬안되있을땐 nLogn, 정렬되있을땐 n
* A그룹과B그룹으로 만들어질수있는 최대 경우의수는 천육백만
* C그룹과D그룹으로 만들어질수있는 최대 경우의수는 천육백만
* 이여서 삼천이백만개 만들어질수 있으니
* 투포인터를 적용했을떄의 시간복잡도 삼천이백만
*
*
* 지금까지의 시간복잡도를 모두 더하면
* 삼천이백만(경우의수 그룹만드는데) + 8억(만들어진 그룹 정렬) + 삼천이백만(투포인터) = 9억
*
* */

/*
* 시간초과 ㅡㅡ왜지
* */





class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/합이_0인_네_정수/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long A[] = new long[n];
        long B[] = new long[n];
        long C[] = new long[n];
        long D[] = new long[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }

        long combList1[] = new long[n * n];
        long combList2[] = new long[n * n];
        {
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long sum1 = A[i] + B[j];
                    long sum2 = C[i] + D[j];
                    combList1[k] = sum1;
                    combList2[k] = sum2;
                    k++;
                }
            }

        }

        Arrays.sort(combList1);
        Arrays.sort(combList2);


        int leftIdx = 0;
        int rightIdx = combList2.length - 1;
        long answer = 0;

        while(leftIdx < combList1.length && rightIdx >= 0){

            long leftSearchValue = combList1[leftIdx];
            long rightSearchValue = combList2[rightIdx];
            long sum = leftSearchValue + rightSearchValue;
            if(sum == 0){

                long leftEqualCount = 0;
                while(leftIdx < combList1.length && combList1[leftIdx] == leftSearchValue){
                    leftIdx++;
                    leftEqualCount++;
                }

                long rightEqualCount = 0;
                while(rightIdx >= 0 && combList2[rightIdx] == rightSearchValue){
                    rightIdx--;
                    rightEqualCount++;
                }

                answer += leftEqualCount * rightEqualCount;
            }else if(sum > 0){
                rightIdx--;
            }else if(sum < 0){
                leftIdx++;
            }
        }


        System.out.println(answer);
    }

}
