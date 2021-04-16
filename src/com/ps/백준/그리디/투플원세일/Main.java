package com.ps.백준.그리디.투플원세일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

/*
* 문제를 풀기전 생각했을떄는 그냥 내림차순으로 정렬해서 비싼거부터 같이 팔면 되나?
* 약간 의문이 들었다. 비싼거랑 적당히비싼거 적절히 조합해서 먼저 구매하면 공짜로 가져오는 금액을
* 더 크게 늘릴수 있지 않을까? 라는 의문이 들었는데
* 고민을 계속해보니 어떻게 조합을 하든 풀이 외에 다른 방법들은 공짜로 가져가는 물품들의
* 가치가 더 낮은것을 가져가게 하는 방법으로 귀결된다(== 더 뒤에있는 물품을 가져가게 만든다)
* */


class Main {
    static int n;
    static Integer goods[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그리디/투플원세일/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        n = Integer.parseInt(br.readLine());
        goods = new Integer[n];
        for (int i = 0; i < n; i++) {
            goods[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(goods, (o1, o2) -> Integer.compare(o2, o1));
//        Arrays.sort(goods, Collections.reverseOrder());

//        for (Integer good : goods) {
//            System.out.println(good);
//        }

        int answer = 0;
        for (int i = 0; i < goods.length; i++) {
            if((i + 1) % 3 == 0) continue;

            answer += goods[i];
        }

        System.out.println(answer);
    }

}
