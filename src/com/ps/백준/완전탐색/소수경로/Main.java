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

class Main {

    static List<Integer> primeNumbers = new ArrayList<>();
    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/소수경로/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 2; i < 10000; i++) {
            boolean isPrime = true;
            for (Integer primeNumber : primeNumbers) {
                if(i % primeNumber == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) primeNumbers.add(i);
        }
        primeNumbers.removeIf(prime -> prime < 1000);
//        primeNumbers.forEach(System.out::println);


        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startPassword = Integer.parseInt(st.nextToken());
            int destPassword = Integer.parseInt(st.nextToken());

            int searchCount = 0;
            Queue<Integer> queue = new LinkedList();
            queue.add(startPassword);
            for (; !queue.isEmpty(); ) {
                int calPassword = queue.poll();

                if(calPassword == destPassword) break;
                if(visited[calPassword] == true) continue;
                else visited[calPassword] = true;


                //방문예정
                int baseSum = Arrays.stream(String.valueOf(calPassword).split("")).map(Integer::valueOf).reduce(0, Integer::sum);
                queue.addAll(primeNumbers.stream().filter(prime -> prime == baseSum + 1).collect(Collectors.toList()));
                queue.addAll(primeNumbers.stream().filter(prime -> prime == baseSum - 1).collect(Collectors.toList()));

                searchCount++;
            }

            System.out.println(searchCount);
        }

    }

}
