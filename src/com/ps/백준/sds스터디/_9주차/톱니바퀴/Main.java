package com.ps.백준.sds스터디._9주차.톱니바퀴;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

/*
* 항상 4개의 톱니바퀴가 주어짐.
* 톱니는 8개의 극을 갖게됨.
* */
class Main {

    static class Command {
        int gearNum;
        int rotationDir;

        public Command(int gearNum, int rotationDir) {
            this.gearNum = gearNum;
            this.rotationDir = rotationDir;
        }
    }


    static int gear[][];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_9주차/톱니바퀴/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        gear = new int[4][8];

        for (int i = 0; i < gear.length; i++) {
            String gearInput = br.readLine();
            for (int j = 0; j < gear[0].length; j++) {
                gear[i][j] = gearInput.charAt(j) - '0';
            }
        }

        Queue<Command> queue = new LinkedList<>();
        int commandCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gearNum = Integer.parseInt(st.nextToken()) - 1;//톱니 1번을 0번으로 계산하기위해 -1
            int rotationDir = Integer.parseInt(st.nextToken());//-1은 반시계, 1은 시계방향

            queue.add(new Command(gearNum, rotationDir));
        }

        simulation(queue);
//        gearPrint();

        int score = calculateScore();
        System.out.println(score);

    }

    private static int calculateScore() {
        int sum = 0;
        for (int i = 0; i < gear.length; i++) {
            sum += gear[i][0] * Math.pow(2, i);
        }

        return sum;
    }

    private static void simulation(Queue<Command> commandQueue) {
        //톱니바퀴가 회전을 하면 그 양옆 톱니바퀴가 영향을 받음.
        //기존에 움직였떤 톱니바퀴가 또 움지깅는것을 막기위해 처리했는지를 기록할 플래그 필요.


        while(!commandQueue.isEmpty()){
            Command command = commandQueue.poll();

            int commandSymbolRight = gear[command.gearNum][2];
            int commandSymbolLeft = gear[command.gearNum][6];

            //커맨드에 따라 첫번쨰 명령 수행
            rotation(command.gearNum, command.rotationDir);
//            gearPrint();


            //첫번쨰 명령의 영향으로 이어지는 나머지 기어들 처리
            //오른쪽에 있는 기어 먼저 처리
            int prevGearNum = command.gearNum;
            int prevGearRotationDir = command.rotationDir;
            int prevGearSymbol = commandSymbolRight;
            for (int rightGearNum = prevGearNum + 1; rightGearNum < gear.length; rightGearNum++) {

                if (prevGearSymbol == gear[rightGearNum][6]) {//극이 같은경우
                    break;
                } else { //극이 다른경우
                    if (prevGearRotationDir == 1){
                        prevGearNum = rightGearNum;
                        prevGearRotationDir = -1;
                        prevGearSymbol = gear[prevGearNum][2];

                        rotation(rightGearNum, -1);

                    }
                    else if (prevGearRotationDir == -1){
                        prevGearNum = rightGearNum;
                        prevGearRotationDir = 1;
                        prevGearSymbol = gear[prevGearNum][2];

                        rotation(rightGearNum, 1);
                    }
                }
            }


            //왼쪽 기어  처리
            prevGearNum = command.gearNum;
            prevGearRotationDir = command.rotationDir;
            prevGearSymbol = commandSymbolLeft;
            for (int leftGearNum = prevGearNum - 1; leftGearNum >= 0; leftGearNum--) {
                if (prevGearSymbol == gear[leftGearNum][2]) {//극이 같은경우
                    break;
                } else { //극이 다른경우
                    if (prevGearRotationDir == 1){
                        prevGearNum = leftGearNum;
                        prevGearRotationDir = -1;
                        prevGearSymbol = gear[prevGearNum][6];

                        rotation(leftGearNum, -1);

                    }
                    else if (prevGearRotationDir == -1){
                        prevGearNum = leftGearNum;
                        prevGearRotationDir = 1;
                        prevGearSymbol = gear[prevGearNum][6];

                        rotation(leftGearNum, 1);

                    }
                }
            }


//            gearPrint();
        }

    }

    private static void gearPrint() {

        for (int i = 0; i < gear.length; i++) {
            System.out.println(Arrays.toString(gear[i]));
        }

        System.out.println("-----------------");

    }

    private static void rotation(int gearNum, int rotationDir) {
        if(rotationDir == 1){
            int temp = gear[gearNum][gear[gearNum].length - 1];

            for (int i = gear[0].length - 1 - 1; i >= 0; i--) {
                gear[gearNum][i + 1] = gear[gearNum][i];
            }
            gear[gearNum][0] = temp;
        }else {
            int temp = gear[gearNum][0];
            for (int i = 0; i < gear[0].length - 1; i++) {
                gear[gearNum][i] = gear[gearNum][i + 1];
            }
            gear[gearNum][gear[0].length - 1] = temp;
        }
    }

}
