package com.ps.프로그래머스.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 스킬트리 {


    public int solution(String skill, String[] skill_trees) {
        String[] split = skill.split("");

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            map.put(split[i], i);
        }


        int result = 0;
        for(String skill_tree : skill_trees){
            int old = 0;
            boolean isSequence = true;

            for (char c : skill.toCharArray()) {
                int cur = skill_tree.indexOf(c);

                if(old == -1 && old < cur){
                    isSequence = false;
                    break;
                }

                if(cur != -1 && old > cur){
                    isSequence = false;
                    break;
                }

                old = cur;
            }

            if(isSequence){
                result++;
            }
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        스킬트리 proposal = new 스킬트리();

        proposal.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }

}
