package com.ps.프로그래머스.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 체육복 {

    /*
     * 두 배열을 비교...
     * 이전에 비슷한 유형을 set으로 풀었던것 같다.
     * 여분 가져왔는데 하나는 도둑맞은 친구들을 필터링해서 순수하게 빌려줄수 있는 친구들을 먼저 선별하자.
     * 아니다...그냥 lost의 카운트에서 reserve의 카운트 뺴서 확인하면 끝나는거 아닌가?
     *
     * 아니였음. 체육복은 바로 앞 OR 바로 뒤에있는 친구들만 빌려줄수있음.
     * 일단 정렬하고 여분 가져왔는데 하나는 도둑맞은 친구들을 필터링해서 순수하게 빌려줄수 있는 친구들을 먼저 선별하자
     * 그다음 안가져온애들 순회하면서 앞뒤에들이 여분있은지 확인하는식으로 하면 될것같음.
     * 잃어버린애 중심으로 앞뒤에있는 애들 접근하기 위해서 배열 하나 따로 만들어서 여분있는애들은 +1, 없는애들은 -1로 하고 순회하면 될듯.
     *
     *
     * 다른 사람들 풀이 보는데 hashset에 reserve다 넣어두고 lost순회하면서 hashset.contain(lost[i] - 1), hashset.contain(lost[i] + 1) 이런식으로 하니까 엄청 간단하게 끝나네
     * */


    public int solution(int n, int[] lost, int[] reserve) {
        int allMemberState[] = new int[n];
        for (int i = 0; i < lost.length; i++) {
            allMemberState[lost[i] - 1]--;
        }

        for (int i = 0; i < reserve.length; i++) {
            allMemberState[reserve[i] - 1]++;
        }

        allMemberState = Arrays.stream(allMemberState).toArray();
        for (int i = 0; i < allMemberState.length; i++) {
            if(allMemberState[i] < 0){

                if(i == 0) {
    //              첫번쨰 학생인경우
                    if(allMemberState[1] > 0){
                        allMemberState[0] = 0;
                        allMemberState[1] = 0;
                    }
                    continue;
                }

                int lastIdx = n - 1;
                if (i == lastIdx) {
                    //마지막 학생인경우
                    if (allMemberState[lastIdx - 1] > 0) {
                        allMemberState[lastIdx] = 0;
                        allMemberState[lastIdx - 1] = 0;
                    }
                    continue;
                }


                if(allMemberState[i - 1] > 0){
                    allMemberState[i - 1]--;
                    allMemberState[i]++;
                }else if(allMemberState[i + 1] > 0){
                    allMemberState[i + 1]--;
                    allMemberState[i]++;
                }
            }
        }


        long result = Arrays.stream(allMemberState)
                .filter(value -> value >= 0)
                .count();

        return (int) result;
    }

//    public int solution(int n, int[] lost, int[] reserve) {
//
//        /*
//        * 다른사람 풀이보고 hash로 푼거 따라해보는데... 출제자가 이걸 의도하고 만든게 아닌것 같다는 느낌이 살짝...?
//        인풋으로 인덱스를 +1증가 시켜서 주는건 이문제에서만 그런게 아니라 프로그래머스에서 주는 문제에는 다 그런식으로 주는데
//        hashset으로 하니까 이게 너무 절묘하게 맞아떨어져서 오히려 의도를 벗어나는 풀이같음.
//        * */
//
//        Set<Integer> store = new HashSet<>();
//        for (Integer value : reserve) {
//            store.add(value);
//        }
//
//        for (Integer value : lost) {
////          여분있는데 잃어버린 친구들 제거
//            if(store.contains(value)){
//                store.remove(value);
//                value = -1;
//            }
//        }
//
//        for (int i = 0; i < lost.length; i++) {
//            if(store.contains(lost[i] - 1)){
//                store.remove(lost[i] - 1);
//                lost[i - 1]--;
//                lost[i]++;
//            }
//        }
//
//        for (int i = 0; i < lost.length; i++) {
//            if(store.contains(lost[i + 1])){
//                store.remove(lost[i + 1]);
//                lost[i + 1]--;
//                lost[i]++;
//            }
//        }
//
//
//
//
//
//    }

    public static void main(String[] args) {
        체육복 proposal = new 체육복();

        {
            int n = 5;
            int lost[] = {2, 4};
            int reverse[] = {1, 3, 5};
            int result = proposal.solution(n, lost, reverse);
            System.out.println(result);
        }
        {
            int n = 3;
            int lost[] = {3};
            int reverse[] = {1};
            int result = proposal.solution(n, lost, reverse);
            System.out.println(result);
        }


    }

}
