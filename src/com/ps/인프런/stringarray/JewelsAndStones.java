package com.ps.인프런.stringarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {


    public int solution(String j, String s) {
        Set<Character> warehouse = new HashSet<>();
        for (Character character : j.toCharArray()) {
            warehouse.add(character);
        }

        int result = 0;
        for (Character c : s.toCharArray()) {
            if(warehouse.contains(c)){
                result++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        JewelsAndStones proposal = new JewelsAndStones();

        String J = "aA";
        String S = "aAAbbbb";
        int result = proposal.solution(J, S);
        System.out.println(result);
    }



}
