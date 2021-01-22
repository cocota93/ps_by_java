package com.ps.백준.완전탐색.소수경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;
import java.util.stream.Collectors;


/*
 * 시간제한은 2초
 * 패스워드는 4자리 고정
 * */

/*
 * 9999까지 소수를 다 찾으면 얼마나 걸릴까?
 *
 *
 * dfs나 bfs같은걸로 어떻게 하면 될것도 같은데...
 * 그리고 인티저로 관리해야할지 문자열로 처리해야할지도 애매한것같음.
 * dfs가 맞는걸까? bfs가 맞는걸까? 최소횟수라 했으니까 bfs가 맞을듯함.
 * */

/*
 * bfs로 구현할떄 재귀 사용없이 그냥 for로 처리하니까 변환횟수 관리가 번거로워진다.
 * */

/*
 * 처음부터 방향을 아에 잘못잡았다. 난 각 자릿수의 합이 1차이나는것들을 찾으면 될거라 생각했는데 그게 아니였다. 반례) 1033의 합은 7, 1016의 합은 8 하지만 2개이상 다름.
 *
 *
 * 풀이 출처 : https://dundung.tistory.com/65
 * */

class Main {

    static List<Integer> primeNumbers = new ArrayList<>();
    static int[] distance = new int[10000];
    static boolean[] visited = new boolean[10000];
    static int destPassword;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/소수경로/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 2; i < 10000; i++) {
            boolean isPrime = true;
            for (Integer primeNumber : primeNumbers) {
                if (i % primeNumber == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primeNumbers.add(i);
        }
        primeNumbers.removeIf(prime -> prime < 1000);
//        primeNumbers.forEach(System.out::println);


        int TMAX = Integer.parseInt(br.readLine());
        for (int t = 0; t < TMAX; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startPassword = Integer.parseInt(st.nextToken());
            destPassword = Integer.parseInt(st.nextToken());

            Arrays.fill(distance, Integer.MAX_VALUE);
            Arrays.fill(visited, false);
            distance[startPassword] = 0;



            Queue<Integer> queue = new LinkedList<>();
            queue.add(startPassword);

            while (!queue.isEmpty()){
                Integer prevPassword = queue.poll();

                for (int orderDigit = 0; orderDigit < 4; orderDigit++) {
                    for (int i = 0; i < 10; i++) {
                        if (orderDigit == 0 && i == 0) continue;

                        StringBuilder sb = new StringBuilder(String.valueOf(prevPassword));
                        int nextPassword = Integer.parseInt(sb.replace(orderDigit, orderDigit + 1, String.valueOf(i)).toString());
                        if(primeNumbers.contains(nextPassword) && !visited[nextPassword]){
                            distance[nextPassword] = Math.min(distance[nextPassword], distance[prevPassword] + 1);
//                            distance[nextPassword] = distance[prevPassword] + 1;
                            visited[nextPassword] = true;
                            queue.add(nextPassword);
                        }
                    }
                }
            }




            System.out.println(distance[destPassword]);
        }

    }

    private static void BFS(int tryPassword, int depth) {
        if (visited[tryPassword] == true) return;

        Queue<Integer> queue = new LinkedList();
        queue.add(tryPassword);
        visited[tryPassword] = true;

        for (; !queue.isEmpty(); ) {
            int calPassword = queue.poll();
            if (calPassword == destPassword) {
                result = depth;
                return;
            } else {
                depth++;
            }


            //방문예정
            int baseSum = Arrays.stream(String.valueOf(calPassword).split("")).map(Integer::valueOf).reduce(0, Integer::sum);
            List<Integer> nextPlusPasswordCandi = primeNumbers.stream().filter(prime -> prime == baseSum + 1 || prime == baseSum - 1).collect(Collectors.toList());
            for (Integer candidate : nextPlusPasswordCandi) {
                if (visited[candidate] == true) continue;

                visited[candidate] = true;
                queue.add(candidate);
            }
        }


    }

}
