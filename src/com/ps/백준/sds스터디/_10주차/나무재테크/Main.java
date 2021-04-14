package com.ps.백준.sds스터디._10주차.나무재테크;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    static class Tree {
        int age;
        int nutrition;

        public Tree(int age, int nutrition) {
            this.age = age;
            this.nutrition = nutrition;
        }
    }

    static int n;
    static int m;//
    static int k;//시뮬레이션 년도

    static int nutritionBoard[][];
    static int extraNutritionBoard[][];
    static List<Tree> treeBoard[][];

    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_10주차/나무재테크/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nutritionBoard = new int[n][n];
        extraNutritionBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int nutrition = Integer.parseInt(st.nextToken());
                extraNutritionBoard[i][j] = nutrition;
                nutritionBoard[i][j] = 5;
            }
        }

        treeBoard = new List[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                treeBoard[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            treeBoard[y][x].add(new Tree(age, 5));
        }


        for (int i = 0; i < k; i++) {
            simulation();
        }


        int answer =0 ;
        for (int i = 0; i < treeBoard.length; i++) {
            for (int j = 0; j < treeBoard[0].length; j++) {
                answer += treeBoard[i][j].size();
            }
        }

        System.out.println(answer);
    }

    private static void simulation() {

        //봄
        for (int i = 0; i < treeBoard.length; i++) {
            for (int j = 0; j < treeBoard[0].length; j++) {

                //나이가 어린 나무부터
                ListIterator<Tree> listIterator = treeBoard[i][j].listIterator(treeBoard[i][j].size());
                for (; listIterator.hasPrevious(); ) {
                    Tree tree = listIterator.previous();

                    if(nutritionBoard[i][j] >= tree.age){
                        nutritionBoard[i][j] -= tree.age;
                        tree.nutrition += tree.age;
                        tree.age += 1;
                    }else {
                        //만약 못하면 해당 나무 사망
                        //사망할떄 해당나무는 다음 계절을 위한 양분이 됨.
                        nutritionBoard[i][j] += tree.age / 2;
                        listIterator.remove();
                        break;
                    }
                }

                //중간에 죽은 나무가 있다면 그거보다 나이많은 애들도 다 죽게됨.
                //나이 어린애가 죽었으니 순서상 당연.
                for (; listIterator.hasPrevious(); ) {
                    Tree tree = listIterator.previous();
                    nutritionBoard[i][j] += tree.age / 2;
                    listIterator.remove();
                }
            }
        }

        //여름



        //가을
        for (int y = 0; y < treeBoard.length; y++) {
            for (int x = 0; x < treeBoard[0].length; x++) {

                for (Tree tree : treeBoard[y][x]) {
                    if(tree.age % 5 != 0) continue;

                    for (int dir = 0; dir < 8; dir++) {
                        int nextY = y + dy[dir];
                        int nextX = x + dx[dir];

                        if(!inRange(nextY, nextX)) continue;

                        treeBoard[nextY][nextX].add(new Tree(1,5));
                    }
                }
            }
        }

        //겨울
        for (int i = 0; i < nutritionBoard.length; i++) {
            for (int j = 0; j < nutritionBoard[0].length; j++) {
                nutritionBoard[i][j] += extraNutritionBoard[i][j];
            }
        }

    }

    private static boolean inRange(int nextY, int nextX) {
        return 0 <= nextY && nextY < nutritionBoard.length && 0 <= nextX && nextX < nutritionBoard[0].length;
    }

}
