package com.ps.백준.완전탐색.부분수열의합2;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

/*
* 부분수열의 합이 s가 되는 경우의 수를 구하는 문제.
* 이것도 투포인터로 풀면 될듯한데??
* -> 투포인터로 제출하니까 틀렸다나옴=_= 왜지?
* -> s가 0일떄 아무것도 안더한상태로 카운팅해버림.
* -> 그외에도 여러가지문제
*
* */

/*
* 부분수열에대해서 잘못 이해하고 있었음.
* 부분수열이란 원래 수열의 일부 항을 순서대로 나열한것.
*  일부 항들이 꼭 연속적일 필요는 없으며 순서만 지킨다면 부분수열을 만족.
*
* 기존처럼 투포인터로 풀었을때 문제는 주어진 시간안에 해결이 안된다는점.
* 때문에 이를 해결하기 위해서는 반을 나눠서 처리해야한다고 한다. (????)
*
* */


/*
* 각 배열에 대한 카운팅이 int범위로 충분할거라 생각해서 int로 카운팅해놓고
* 결과는 long으로 받았다.
* long = int * int;
* 이렇게 계산하면 곱하기의 연산 결과가 int범위를 넘어갈때 문제가된다. 떄문에
* long = long * long으로 해야 의도에 맞게 결과가 나온다.
* */


class Main {

    static int inputSequenceArr[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/부분수열의합2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        inputSequenceArr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < inputSequenceArr.length; i++) {
            inputSequenceArr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> leftArray = new ArrayList<>();
        {
            int sum = 0;
            int startIdx = 0;
            int endIdx = n / 2;
            makeSumArray(sum, startIdx, endIdx, leftArray);
        }
        leftArray.sort(Comparator.comparingInt(Integer::intValue));


        List<Integer> rightArray = new ArrayList<>();
        {
            int sum = 0;
            int startIdx = n / 2;
            int endIdx = n;
            makeSumArray(sum, startIdx, endIdx, rightArray);
        }
        rightArray.sort(Comparator.comparingInt(Integer::intValue));


        long answer = 0;

        int leftSearchIdx = 0;
        int rightSearchIdx = rightArray.size() - 1;
        while(leftSearchIdx <= leftArray.size() - 1 && rightSearchIdx >= 0){
            long leftSearchValue = leftArray.get(leftSearchIdx);
            long rightSearchValue = rightArray.get(rightSearchIdx);
            long addResult = leftSearchValue + rightSearchValue;
            if(addResult == s){

                long leftEqualValueCount = 0;
                for (int i = leftSearchIdx; i < leftArray.size(); i++) {
                    if(leftArray.get(i) == leftSearchValue){
                        leftSearchIdx++;
                        leftEqualValueCount++;
                    }else {
                        break;
                    }
                }

                long rightEqualValueCount = 0;
                for (int i = rightSearchIdx; i >= 0; i--) {
                    if(rightArray.get(i) == rightSearchValue){
                        rightSearchIdx--;
                        rightEqualValueCount++;
                    }else {
                        break;
                    }
                }


                answer += leftEqualValueCount * rightEqualValueCount;
            } else if(addResult > s){
                rightSearchIdx--;
            } else if(addResult < s){
                leftSearchIdx++;
            }
        }

        //leftArray의 0과 rightArray의 0이 만드는 0 + 0형태의 공집합 제거
        if(s == 0) answer -= 1;

        System.out.println(answer);
    }

    private static void makeSumArray(int sum, int startIdx, int endIdx, List<Integer> saveContainer) {
        if(startIdx == endIdx){
            saveContainer.add(sum);
            return;
        }

        makeSumArray(sum + inputSequenceArr[startIdx], startIdx + 1, endIdx, saveContainer);
        makeSumArray(sum, startIdx + 1, endIdx, saveContainer);

    }

}
