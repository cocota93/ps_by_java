package com.ps.백준.이진탐색.나무자르기;

import java.io.*;
import java.util.*;

/*
 * 이분탐색이라고 분류되어있는데 내가 느끼기엔 해당분류에 안맞는데 억지로 끼워 넣어둔 느낌이다.
 *  코드에 minValue, maxValue도 전혀 필요없어보이는데 다른사람들 코드 보니까 이렇게 해놨길래 일단은 해놨다 ㅡㅡ.
 * 이건 그냥 탐색을 시작하는 값이 중간부터 시작일뿐 단순 for문 으로 봐야되는거 아닌가?
 * -> 고쳐볼려고 했더니 뭔가 절묘하게 minValue, maxValue가 필요하긴한데 음....맘에는 안드네
 * 풀이출처 : https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-2805-%EB%82%98%EB%AC%B4-%EC%9E%90%EB%A5%B4%EA%B8%B0
 * */


class Main {
    static long[] treeContainer;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/이진탐색/나무자르기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int treeCount = Integer.parseInt(st.nextToken());
        long needAmount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        treeContainer = new long[treeCount];
        long minValue = 0;
        long maxValue = 0;
        for (int i = 0; i < treeCount; i++) {
            treeContainer[i] = Long.parseLong(st.nextToken());
            maxValue = Math.max(maxValue, treeContainer[i]);
        }
//        Arrays.sort(treeContainer);

        long resultHeight = 0;
        while (minValue <= maxValue) {
            long midValue = (minValue + maxValue) / 2;
            long tempSum = 0;

            for (int i = 0; i < treeContainer.length; i++) {
                if (treeContainer[i] <= midValue) continue;
                tempSum += treeContainer[i] - midValue;
            }

            if (tempSum >= needAmount) {
                minValue = midValue + 1;
                resultHeight = Math.max(resultHeight, midValue);
            } else {
                maxValue = midValue - 1;
            }
        }

        System.out.println(resultHeight);

    }


    private static long BinarySearchByIndex(Long findValue) {
        int searchStartIndex = 0;
        int searchEndIndex = treeContainer.length;
        long searchResultIndex = -1;

        while (searchStartIndex < searchEndIndex) {
            int centerIndex = (searchStartIndex + searchEndIndex) / 2;
            if (findValue < treeContainer[centerIndex]) {
                //찾는값이 중앙보다 왼쪽에 있다는 의미.
                searchEndIndex = centerIndex - 1;
            } else if (findValue > treeContainer[centerIndex]) {
                //찾는값이 중앙보다 오른쪽에 있다는 의미.
                searchStartIndex = centerIndex + 1;
            } else {
                //찾음.
                searchResultIndex = centerIndex;
                break;
            }
        }

        return searchResultIndex;
    }

}
