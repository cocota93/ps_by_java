//package com.ps.백준.역량테스트.뱀;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.io.FileInputStream;
//import java.util.StringTokenizer;
//
//
//class Main {
//
//    static class DirMetaInfo{
//        private static int dirDelta[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//
//        static class DirDelta {
//            int y;
//            int x;
//            DirMark dirMark;
//
//            public DirDelta(int y, int x, DirMark dirMark) {
//                this.y = y;
//                this.x = x;
//                this.dirMark = dirMark;
//            }
//        }
//
//        public enum DirMark {
//            UP,
//            RIGHT,
//            DOWN,
//            LEFT
//        }
//
//        public static int Length(){
//            return DirMark.values().length;
//        }
//
//        public static DirMark[] GetEnums() {
//            return DirMark.values();
//        }
//
//        public static DirDelta Get(DirMark dirMark){
//            int ordinal = dirMark.ordinal();
//            return new DirDelta(dirDelta[ordinal][0], dirDelta[ordinal][1], dirMark);
//        }
//    }
//
//    static class Snake{
//        int y;
//        int x;
//        DirMetaInfo.DirMark dir;
//
//        public Snake(int y, int x, DirMetaInfo.DirMark dir) {
//            this.y = y;
//            this.x = x;
//            this.dir = dir;
//        }
//    }
//
//    private static int Simul(int[][] board, Queue<Command> commandQueue, Snake snake) {
//
//
//        int time = 0;
//        for(;!commandQueue.isEmpty();){
//            time++;
//
//            DirMetaInfo.DirDelta moveDistance = DirMetaInfo.Get(snake.dir);
//            int dy = snake.y + moveDistance.y;
//            int dx = snake.x + moveDistance.x;
//
//            if(dy < 0 || dy >= board.length) return time;
//            if(dx < 0 || dx >= board[0].length) return time;
//
//            if(board[dy][dx] != 9){
//
//            }
//            board[dy][dx] = 1;
//
//            if(time <= commandQueue.peek().time ) continue;
//
//            Command command = commandQueue.poll();
//            //방향전환
//
//
//
////            for (int i = 0; i < command.time; i++) {
////            }
//
//        }
//
//        return 0;
//    }
//
//
//
//    static class Command {
//        int time;
//        char rot;
//
//        public Command(int time, char rot) {
//            this.time = time;
//            this.rot = rot;
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/역량테스트/뱀/input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int n = Integer.parseInt(br.readLine());
//        int board[][] = new int[n][n];
//
//        int k = Integer.parseInt(br.readLine());
//        for (int i = 0; i < k; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int y = Integer.parseInt(st.nextToken());
//            int x = Integer.parseInt(st.nextToken());
//
//            board[y][x] = 9;
//        }
//
//        Queue<Command> commandQueue = new LinkedList<>();
//        int L = Integer.parseInt(br.readLine());
//        for (int i = 0; i < L; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int x = Integer.parseInt(st.nextToken());
//            String C = st.nextToken();
//
//            Command command = new Command(x, C.charAt(0));
//            commandQueue.add(command);
//        }
//
//
//        Snake snake = new Snake(0, 0, DirMetaInfo.DirMark.RIGHT);
//        board[0][0] = 1;
//        Simul(board, commandQueue, snake);
//
//
//    }
//
//}
