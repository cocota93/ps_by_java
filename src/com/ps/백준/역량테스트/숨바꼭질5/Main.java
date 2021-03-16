package com.ps.백준.역량테스트.숨바꼭질5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//동생을 찾을수 없거나 위치가 50만을 넘으면 -1 출력
//수빈이는 한칸 이동 or 현재위치 * 2 할수 있다.
//동생은 시간이 지날수록 더 빨리 이동한다.

//동생의 위치가 변한다는게 중요한 포인트 인것 같다.
//그냥 동생이랑 위치 같을때까지 계속 움직여 보는 방법밖에 없지않나???



//매초마다 수빈이가 이동할수 있는 위치에 필요시간 업데이트 해주고
//동생 위치 업데이트 할때 수빈이랑 위치 겹치는지 확인해주자.
//수빈이가 해당 위치에 갈수있는 시간대가 여러번이 되면 어카지?


class Main {

    static List<Integer> subinPosHistory[];
    static int subinPos;


    static int broPosHistory[];
    static int broPos;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/역량테스트/숨바꼭질5/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());//수빈이의 위치
        int k = Integer.parseInt(st.nextToken());//동생의 위치

        subinPosHistory = new List[500001];
        for (int i = 0; i < subinPosHistory.length; i++) {
            subinPosHistory[i] = new ArrayList<>();
        }
        subinPos = n;
        subinPosHistory[0].add(subinPos);


        broPosHistory = new int[500001];
        broPos = k;
        broPosHistory[0] = broPos;


        if(subinPos == broPos){
            System.out.println(0);
            return;
        }

        for (int time = 1; time <= 500000; ++time){

            broPosHistory[time] = broPosHistory[time - 1] + time;

            for (Integer oldPos : subinPosHistory[time - 1]) {
                subinPosHistory[time].add(oldPos + 1);
                subinPosHistory[time].add(oldPos - 1);
                subinPosHistory[time].add(oldPos * 2);
            }

            for (Integer pos : subinPosHistory[time]) {
                if(pos == broPosHistory[time] && pos <= 500000){
                    System.out.println(time);
                    return;
                }
            }
        }

        System.out.println(0);
    }

}
