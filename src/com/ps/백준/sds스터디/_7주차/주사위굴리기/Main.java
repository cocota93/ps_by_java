package com.ps.백준.sds스터디._7주차.주사위굴리기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


/*
* 문제이해가 어려웠음.
*
* */

class Main {
//  동서북남
    static int dy[] = {0 , 0, -1, 1};
    static int dx[] = {1, -1, 0, 0};

    static int board[][];
    static int dice[];

    static int dice_dir_top = 1 - 1;
    static int dice_dir_bottom = 6 - 1;

    static int dice_dir_right = 3 - 1;
    static int dice_dir_left = 4 - 1;
    static int dice_dir_north = 2 - 1;
    static int dice_dir_south = 5 - 1;
    //1 윗면
    //6 아랫면

    //3 오른쪽
    //4 왼쪽
    //2 북쪽
    //5 남쪽


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_7주차/주사위굴리기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int diceY = Integer.parseInt(st.nextToken());
        int diceX = Integer.parseInt(st.nextToken());
        int commandCount = Integer.parseInt(st.nextToken());

        board = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> commandQueue = new LinkedList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < commandCount; i++) {
            commandQueue.add(Integer.parseInt(st.nextToken()));
        }

        dice = new int[6];

        //주사위 이동에 따른 바닥면 인덱스 구하는 함수
        //


//       이동할떄마다 주사위 윗면 숫자 출력
//        이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다. 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
/*
*       if(board[y][x] == 0){
*           board[y][x] = 주사위바닥칸
*       }else {
*           주사위바닥면 = board[y][x]
*       }
* */

        while(!commandQueue.isEmpty()){
            Integer dir = commandQueue.poll();

            int nextDiceY = diceY + dy[dir - 1];
            int nextDiceX = diceX + dx[dir - 1];
            if(nextDiceX < 0 ||  board[0].length <= nextDiceX ) continue;
            if(nextDiceY < 0 ||  board.length <= nextDiceY ) continue;

            diceReDesign(dice, dir);
            diceY = nextDiceY;
            diceX = nextDiceX;

            if(board[diceY][diceX] == 0){
                board[diceY][diceX] = dice[dice_dir_bottom];
            }else{
                dice[dice_dir_bottom] = board[diceY][diceX];
                board[diceY][diceX] = 0;
            }

            System.out.println(dice[dice_dir_top]);
        }

    }

    private static void diceReDesign(int[] dice, Integer dir) {
        int beforeDice[] = new int[dice.length];
        beforeDice = Arrays.copyOf(dice, dice.length);

        if(dir == 1){//동
            //북쪽과 남쪽은 영향 안받음
            dice[dice_dir_top] = beforeDice[dice_dir_left];
            dice[dice_dir_right] = beforeDice[dice_dir_top];
            dice[dice_dir_bottom] = beforeDice[dice_dir_right];
            dice[dice_dir_left] = beforeDice[dice_dir_bottom];
        }else if(dir == 2){//서
            //북쪽과 남쪽은 영향 안받음
            dice[dice_dir_top] = beforeDice[dice_dir_right];
            dice[dice_dir_right] = beforeDice[dice_dir_bottom];
            dice[dice_dir_bottom] = beforeDice[dice_dir_left];
            dice[dice_dir_left] = beforeDice[dice_dir_top];
        }else if(dir == 3){//북
            //왼쪽과 오른쪽은 영향 안받음
            dice[dice_dir_top] = beforeDice[dice_dir_south];
            dice[dice_dir_south] = beforeDice[dice_dir_bottom];
            dice[dice_dir_bottom] = beforeDice[dice_dir_north];
            dice[dice_dir_north] = beforeDice[dice_dir_top];
        }else if(dir == 4){//남
            //왼쪽과 오른쪽은 영향 안받음
            dice[dice_dir_top] = beforeDice[dice_dir_north];
            dice[dice_dir_north] = beforeDice[dice_dir_bottom];
            dice[dice_dir_bottom] = beforeDice[dice_dir_south];
            dice[dice_dir_south] = beforeDice[dice_dir_top];
        }

    }

}
