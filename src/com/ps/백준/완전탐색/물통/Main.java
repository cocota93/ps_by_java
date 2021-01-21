package com.ps.백준.완전탐색.물통;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

/*
* 처음 봤을때는 어떻게 풀어야 할지 감이 안와서 이전에 풀다가 만 문제들 풀고 다시 왔는데
* 그냥 세가지로 만들수있는 모든 경우의수 탐색하면서 부호 바꿔주는 정도로 하면 될것같다.
* 잠깐. 처음 시작할때 세번쨰 물통만 가득차있네?
*
* 음....이거 나올수 있는 경우의 수가 10개이하로 정해진것 같기도?
* 10 1 6 일때 7가지 나옴.
* 10 4 6 일떄 4가지
* 10 7 6 일때 2가지
*
* 5 1 6 일때 2가지
* 5 4 6 일때 2가지
* 5 7 6 일때 2가지
*
* 딱히 뭔 규칙은 없는듯한데;;
*
*
* 재귀로 구현하고
* 종료조건은 3번물통에 있는 물이 바닥날떄까지로 하면 되지않을까?
* */


/*
* 문제를 잘 읽어야 한다는걸 다시 느꼈다. 문제를 보면
* '이때에는 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다.' 라고 되어있다.
* a물통에서 b물통으로 붓다가 b가 먼저 차버려도 괜찮다는거다...예시에서도 c에서 b로 부을때 똑같이 그랬는데
* 왜 엉뚱하게 생각하고 있었지;;
* 그리고 답을 구하는 시점도 '첫 번째 물통(용량이 A인)이 비어 있을 때, blahblah ~  구해내는 프로그램을 작성하시오.'
* 라고 주고있는데 제대로 안읽었기 떄문에 이전에 재귀로 구현하면 어떤 시점에 종료해야할지 모르고 헤메게 된것 갔다.
*
* 풀이 출처 : https://redcoder.tistory.com/51
*
* 보통 구현은 재귀형태로 구현하여 파라미터에  각 경우의 물통값을 넣던가
* 별도의 자료형을 만들어 큐에다가 각 물통에 대한 정보를 보관하는 구현으로 나뉘는것 같다.
* 난 별도의 자료형 만드는게 더 보기 좋고 쉬운것 같아서 그렇게 해봐야 겠다.
* */

class Main {

    static class BottleSnapShot{
        int bottleA;
        int bottleB;
        int bottleC;



        public BottleSnapShot(int bottleA, int bottleB, int bottleC) {
            this.bottleA = bottleA;
            this.bottleB = bottleB;
            this.bottleC = bottleC;
        }
    }

    static int bottleMaxCapacityA;
    static int bottleMaxCapacityB;
    static int bottleMaxCapacityC;
    static boolean enqueueState[][][] = new boolean[201][201][201];
    static Queue<BottleSnapShot> bottleSnapShotQueue = new LinkedList<>();
    static Set<Integer> answer = new HashSet<>();

    static int loopCounterForDebug;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/물통/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        bottleMaxCapacityA = Integer.parseInt(st.nextToken());
        bottleMaxCapacityB = Integer.parseInt(st.nextToken());
        bottleMaxCapacityC = Integer.parseInt(st.nextToken());

        DFS(0, 0, bottleMaxCapacityC);


        Iterator<Integer> iterator = answer.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.printf("%d ", next);
        }

    }

    private static void DFS(int a, int b, int c) {
        bottleSnapShotQueue.add(new BottleSnapShot(a,b,c));

        while(!bottleSnapShotQueue.isEmpty()){
            loopCounterForDebug++;
            BottleSnapShot snapShot = bottleSnapShotQueue.poll();

            if(snapShot.bottleA + snapShot.bottleB + snapShot.bottleC != 10){
                System.out.println("debug");
            }

            if(enqueueState[snapShot.bottleA][snapShot.bottleB][snapShot.bottleC]) continue;
            else enqueueState[snapShot.bottleA][snapShot.bottleB][snapShot.bottleC] = true;

            if(snapShot.bottleA == 0){
                answer.add(snapShot.bottleC);
            }

            //a에서 b로 물을 따를때
            if(snapShot.bottleA + snapShot.bottleB > bottleMaxCapacityB){//a에서 b로 줄수있는 양이 초과되어 일부만 주어야 할때
                bottleSnapShotQueue.add(new BottleSnapShot(snapShot.bottleA + (snapShot.bottleB - bottleMaxCapacityB), bottleMaxCapacityB, snapShot.bottleC));
            }else {
                bottleSnapShotQueue.add(new BottleSnapShot(0, snapShot.bottleA + snapShot.bottleB, snapShot.bottleC));
            }

            //a -> c
            if(snapShot.bottleA + snapShot.bottleC > bottleMaxCapacityC){
                bottleSnapShotQueue.add(new BottleSnapShot(snapShot.bottleA + (snapShot.bottleC - bottleMaxCapacityC), snapShot.bottleB,bottleMaxCapacityC));
            }else{
                bottleSnapShotQueue.add(new BottleSnapShot(0,snapShot.bottleB,snapShot.bottleA + snapShot.bottleC));
            }

            //b -> a
            if(snapShot.bottleB + snapShot.bottleA > bottleMaxCapacityA){
                bottleSnapShotQueue.add(new BottleSnapShot(bottleMaxCapacityA, snapShot.bottleB + (snapShot.bottleA - bottleMaxCapacityA), snapShot.bottleC));
            }else {
                bottleSnapShotQueue.add(new BottleSnapShot(snapShot.bottleA + snapShot.bottleB, 0, snapShot.bottleC));
            }

            //b -> c
            if(snapShot.bottleB + snapShot.bottleC > bottleMaxCapacityC){
                bottleSnapShotQueue.add(new BottleSnapShot(snapShot.bottleA, snapShot.bottleB + (snapShot.bottleC - bottleMaxCapacityC), bottleMaxCapacityC));
            }else{
                bottleSnapShotQueue.add(new BottleSnapShot(snapShot.bottleA,0, bottleMaxCapacityC));
            }


            //c -> a
            if(snapShot.bottleC + snapShot.bottleA > bottleMaxCapacityA){
                bottleSnapShotQueue.add(new BottleSnapShot(bottleMaxCapacityA, snapShot.bottleB, snapShot.bottleC + (snapShot.bottleA - bottleMaxCapacityA)));
            }else {
                bottleSnapShotQueue.add(new BottleSnapShot(snapShot.bottleA + snapShot.bottleC, snapShot.bottleB, 0));
            }

            //c -> b
            if(snapShot.bottleB + snapShot.bottleC > bottleMaxCapacityB){
                bottleSnapShotQueue.add(new BottleSnapShot(snapShot.bottleA, bottleMaxCapacityB, snapShot.bottleC + (snapShot.bottleB - bottleMaxCapacityB)));
            }else{
                bottleSnapShotQueue.add(new BottleSnapShot(snapShot.bottleA,bottleMaxCapacityB, 0));
            }


        }

    }


}
