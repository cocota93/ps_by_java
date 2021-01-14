package com.ps.프로그래머스.level1;

import com.sun.deploy.util.StringUtils;

import javax.management.relation.RelationSupport;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 완주하지_못한_선수 {


//    public String solution(String[] participant, String[] completion) {
//        List<String> sortParti = Arrays.stream(participant).sorted().collect(Collectors.toList());
//        List<String> sortComp = Arrays.stream(completion).sorted().collect(Collectors.toList());
//
//        String result = "";
//
//        for(int i =0 ; i  < sortParti.size(); ++i){
//            String member = sortParti.get(i);
//
//            if(i >= sortComp.size()){
//                result = member;
//                break;
//            }
//
//            String compMember =  sortComp.get(i);
//
//            if(!member.equals(compMember)){
//                result = member;
//                break;
//            }
//
//            if(result != ""){
//                break;
//            }
//        }
//
//        return result;
//
//        /*
//        *
//        *  테스트 1 〉	통과 (3.42ms, 52.3MB)
//        테스트 2 〉	통과 (5.30ms, 52.8MB)
//        테스트 3 〉	통과 (8.00ms, 53.3MB)
//        테스트 4 〉	통과 (9.03ms, 53.1MB)
//        테스트 5 〉	통과 (13.37ms, 53.4MB)
//        효율성  테스트
//        테스트 1 〉	통과 (159.48ms, 83.1MB)
//        테스트 2 〉	통과 (245.40ms, 91.2MB)
//        테스트 3 〉	통과 (241.22ms, 93.8MB)
//        테스트 4 〉	통과 (253.88ms, 94.8MB)
//        테스트 5 〉	통과 (242.23ms, 95.6MB)
//        *
//        * */
//    }

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> store = new HashMap<>();
        for (String s : participant) {
            store.put(s, store.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            store.put(s,store.get(s) - 1);
        }

        String result = "";
        for (String s : store.keySet()) {
            if(store.get(s) != 0){
                result = s;
                break;
            }
        }

        return result;

        /*
정확성  테스트
테스트 1 〉	통과 (0.06ms, 51.9MB)
테스트 2 〉	통과 (0.07ms, 52.5MB)
테스트 3 〉	통과 (0.63ms, 53.4MB)
테스트 4 〉	통과 (1.37ms, 54MB)
테스트 5 〉	통과 (1.35ms, 54.1MB)
효율성  테스트
테스트 1 〉	통과 (39.58ms, 81.6MB)
테스트 2 〉	통과 (86.68ms, 89.1MB)
테스트 3 〉	통과 (89.79ms, 96.2MB)
테스트 4 〉	통과 (93.50ms, 95.7MB)
테스트 5 〉	통과 (95.00ms, 95.6MB)
        *
        *
        * */
    }

    public static void main(String[] args) {
        완주하지_못한_선수 proposal = new 완주하지_못한_선수();
        String  participant[] = {"leo", "kiki", "eden"};
        String  completion[] = {"eden", "kiki"};
        String result = proposal.solution(participant, completion);
        System.out.println(result);
    }

}
