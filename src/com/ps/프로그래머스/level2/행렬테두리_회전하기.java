package com.ps.프로그래머스.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class 행렬테두리_회전하기 {

    static int[][] board;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        board = new int[rows][columns];
        int count = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
//                board[i][j] = count;
                board[i][j] = (i * columns) + (j + 1);
                count++;
            }
        }

        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;

            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int minNum = rotate(x1, y1, x2, y2);
            answerList.add(minNum);
            printBoard(board);
        }

        answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    private void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    private int rotate(int row1, int col1, int row2, int col2) {


        int startNum = board[row1][col1];
        int minNum = startNum;

        //left
        for (int i = row1; i < row2; i++) {
            board[i][col1] = board[i + 1][col1];
            minNum = Math.min(minNum, board[i][col1]);
        }

        //bottom
        for (int i = col1; i < col2; i++) {
            board[row2][i] = board[row2][i + 1];
            minNum = Math.min(minNum, board[row2][i]);
        }

        //right
        for (int i = row2; i > row1 ; i--) {
            board[i][col2] = board[i - 1][col2];
            minNum = Math.min(minNum, board[i][col2]);
        }

        //top
        for (int i = col2; i > col1; i--) {
            board[row1][i] = board[row1][i - 1];
            minNum = Math.min(minNum, board[row1][i]);
        }

        board[row1][col1 + 1] = startNum;

        return minNum;
    }


    public static void main(String[] args) throws Exception {
        행렬테두리_회전하기 proposal = new 행렬테두리_회전하기();

        /*디버깅용 입출력 */
//        System.setIn(new FileInputStream("src/com/ps/프로그래머스/level2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");
//        int a = Integer.parseInt(st.nextToken());
//        System.out.println(a);

//        int input[] = {1, 2, 3, 4};
//        proposal.solution(input);
    }

}
