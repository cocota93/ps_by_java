package com.ps.백준.그리디.병든나이트;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 이것도 왜 그리디인지 잘 모르곘다. 일단 풀이방법을 조금 고민해봤는데 아래처럼 결론이 났다.
 * 1. (n, m)이 (2, 3)이상 or (3, 2)이상이면 방문칸 최소 2이상
 * 2. N = 3 일떄 오른쪽 벽에 부딪히려면 방문칸 최대 M(방향에 신경안쓸때)
 *   모든 방향 1번씩 할려면 오른쪽으로 1칸씩 2번 더 가야되므로(체스의 4가지 움직임을 살펴보면 알수있음) 방문칸은 M - 2
 * 3. (n, m)이 (3, 7) 이상 되야 4방향 가능
 * 4. (n, m)이 (3, 5) 이상 부터는  이동횟수가 4번 이상이므로 이동방향에 제약이 생김.
 * 5. (n, m)이 (2, 9) 이상부터는 이동횟수가 4번 이상이므로 이동방향에 제약이 생김.
 * 태블릿에 체스판그려놓고 생각하면 쉬움.
 * */


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그리디/병든나이트/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N == 0 || M == 0){
            System.out.println(0);
            return;
        }

        if(N == 1){
            System.out.println(1);
            return;
        }

        if (N == 2) {
            int visitTileCount = (M + 1) / 2;
            if (M >= 9) {
                visitTileCount = 4;
            }
            System.out.println(visitTileCount);
            return;
        }

        if(N >= 3 && M < 7){
            int visitTileCount = M;
            if(M >= 5){
                visitTileCount = 4;
            }
            System.out.println(visitTileCount);
            return;
        }


        System.out.println(M - 2);
    }

}
