package com.ps.프로그래머스.level1;

import java.util.*;
import java.util.stream.Collectors;

public class 모의고사 {


//    public int[] solution(int[] answers) {
//        int progress = 0;
//
////1234512345
////2122232425
////3311224455
//
//        int playerPattern[][] = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
//
//
//        //카운팅, 비교에의한 증감...
//        //그냥 순회하면서 키운팅하는게 끝아닌가? 문제의 의도를 모르겠네?
//        //최고점수를 받은 사람이 여럿일수있고 오름차순으로 정렬해서 리턴해줘야 하는데
//        // 무식하게 안짜고 깔끔하게 어떻게 처리할건지 물어보는것 같다.
//
//        //음...어떤 자료구조를 쓰든 stream.filter로 다 비슷하게 구현 가능할것 같긴한데...
//        //stream.filter안쓰고 최고점수인 플레이어들만 저장하는 방법?? 글쎼 그럴려면 일단 최고점수가 몇점인지 알아야하지않나??
//        //그럼 일부만 저장하기는 힘드니 전부다 저장하는 대신 자료구조의 특성으로 stream.filter처럼 알아서 분류되도록 해야겠네
//        //최대힙 + 리스트??
//
//        //음 방금전까지만 해도 최대힙말고 그냥 맵 + 리스트 조합으로 해도 똑같지 않나? 생각했었는데 다시 생각해보니 그렇게되면 최고점수가 몇점인지 알기위해서 또 탐색하거나
//        //Queue선언하자마자 잘못 생각하고 있던걸 꺠달았다. 큐는 키맵구조가 아니기 떄문에 큐를 이용할려면 별도의 구조체같은 클래스를 하나 더 만들어야 한다.
//        //음 현업에서 비슷한 상황을 만났다면 별도의 클래스를 만들기보다는 변수 하나 더 만들고 넘어갔을것 같다. map을 이용해서 해결해보자.
//
//        //플레이어 패턴이 항상 더 큰가?아니. 인풋값이 1만까지 들어올수 있으니까 그부분에 대해서도 처리해줘야함
//
//        Map<Integer, List<Integer>> scoreBoard = new HashMap<>();
//
//        int max = 0;
//        for (int playerIdx = 0; playerIdx < playerPattern.length; playerIdx++) {
//            int tempMax = 0;
//            for (int j = 0; j < answers.length; j++) {
//                int playerPatternPeriod = playerPattern[playerIdx].length;
//                if (answers[j] == playerPattern[playerIdx][j % playerPatternPeriod]) {
//                    tempMax++;
//                }
//            }
//
//            List<Integer> boardRow = scoreBoard.getOrDefault(tempMax, new ArrayList<>());
//            boardRow.add(playerIdx);
//            scoreBoard.put(tempMax, boardRow);
//
//            max = Math.max(max, tempMax);
//        }
//
//        return scoreBoard.get(max).stream().sorted().mapToInt(value -> value + 1).toArray();

    /*
    * 테스트 1 〉	통과 (3.40ms, 52.4MB)
테스트 2 〉	통과 (3.23ms, 55.7MB)
테스트 3 〉	통과 (8.18ms, 52.9MB)
테스트 4 〉	통과 (11.97ms, 52.6MB)
테스트 5 〉	통과 (2.69ms, 53.1MB)
테스트 6 〉	통과 (3.25ms, 52MB)
테스트 7 〉	통과 (4.33ms, 52.5MB)
테스트 8 〉	통과 (3.54ms, 52.5MB)
테스트 9 〉	통과 (4.58ms, 53.8MB)
테스트 10 〉	통과 (6.72ms, 52.6MB)
테스트 11 〉	통과 (7.33ms, 54MB)
테스트 12 〉	통과 (6.21ms, 52.6MB)
테스트 13 〉	통과 (3.78ms, 52.1MB)
테스트 14 〉	통과 (11.05ms, 54.2MB)
*
    *
    * */
//    }

    public int[] solution(int[] answers) {
        int playerPattern[][] = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};

        int score[] = new int[playerPattern.length];

        for (int playerIdx = 0; playerIdx < playerPattern.length; playerIdx++) {
            for (int i = 0; i < answers.length; i++) {
                int playerPatternPeriod = playerPattern[playerIdx].length;
                if(answers[i] == playerPattern[playerIdx][i % playerPatternPeriod]){
                    score[playerIdx]++;
                }
            }
        }

        int max = Arrays.stream(score).max().getAsInt();

        List<Integer> maxScorePlayerIdxList = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if(score[i] == max){
                maxScorePlayerIdxList.add(i);
            }
        }

        int[] result = maxScorePlayerIdxList.stream().mapToInt(value -> value + 1).toArray();
        return result;

        /*
        * 테스트 1 〉	통과 (3.52ms, 52.5MB)
테스트 2 〉	통과 (8.37ms, 51.9MB)
테스트 3 〉	통과 (4.16ms, 52.2MB)
테스트 4 〉	통과 (3.86ms, 52.2MB)
테스트 5 〉	통과 (3.30ms, 53.3MB)
테스트 6 〉	통과 (3.41ms, 53.3MB)
테스트 7 〉	통과 (3.90ms, 52.3MB)
테스트 8 〉	통과 (7.42ms, 52.5MB)
테스트 9 〉	통과 (5.12ms, 54.5MB)
테스트 10 〉	통과 (8.24ms, 52.7MB)
테스트 11 〉	통과 (7.75ms, 53.1MB)
테스트 12 〉	통과 (7.86ms, 52.7MB)
테스트 13 〉	통과 (5.89ms, 52.4MB)
테스트 14 〉	통과 (9.56ms, 52.5MB)
        *
        *
        * */
    }


    public static void main(String[] args) {
        모의고사 proposal = new 모의고사();

//        int input[] = {1,2,3,4,5};//모의고사 정답
        int input[] = {1,3,2,4,2};//모의고사 정답
        int[] result = proposal.solution(input);
        System.out.println(Arrays.toString(result));
    }

}
