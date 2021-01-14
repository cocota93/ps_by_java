package com.ps.미니라이브러리.상하좌우shift;

public class 상하좌우shift {

    //여기서의 x는 일반적인 좌표계의 xy가 아님.
    //x는 행, y는 열을 의미.
    public int[] solution(int[] input) {
        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        int board[][] = new int[][]{
                {2, 3, 1, 5, 4}
                , {1, 3, 5, 4, 2}
                , {1, 8, 3, 6, 1}
                , {8, 9, 7, 2, 4}
        };

        int curX = 2;
        int curY = 2;
        int direction = 3;
        int distance = 2;


        int result = board[curX + (dx[direction] * distance)][curY + (dy[direction] * distance)];
        System.out.println(result);

        int progress = 0;

        return input;
    }

    
    //이동하는 과정에서 각 칸마다 뭔가 해야하는경우
    public int[] solution2(int[] input) {
        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        int board[][] = new int[][]{
                {2, 3, 1, 5, 4}
                , {1, 3, 5, 4, 2}
                , {1, 8, 3, 6, 1}
                , {8, 9, 7, 2, 4}
        };

        int curX = 2;
        int curY = 2;
        int direction = 3;
        int distance = 2;

        for (int i = 1; i <= distance; i++) {
            int tempX = curX + (dx[direction] * 1);
            int tempY = curY + (dy[direction] * 1);

            if(tempX < 0 || tempX >= board[0].length) break;
            if(tempY < 0 || tempY >= board.length) break;

            int result = board[tempX][tempY];
            System.out.println(result);

            if(result == -1) break;

            curX = tempX;
            curY = tempY;
        }


        int progress = 0;

        return input;
    }

    public static void main(String[] args) {
        상하좌우shift proposal = new 상하좌우shift();

        int input[] = {1, 2, 3, 4};
        proposal.solution(input);
        proposal.solution2(input);
    }

}
