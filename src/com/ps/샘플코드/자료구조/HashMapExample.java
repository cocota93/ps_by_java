package com.ps.샘플코드.자료구조;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {


    public void solution() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"hihi1");
        map.put(3,"hihi3");
        map.put(4,"hihi4");
        map.put(2,"hihi2");
        map.put(5,"hihi5");

        System.out.println(map);//자동으로 정렬된것 같지만 HashMap은 내부 hash값에 의해 정렬되어지므로 특정 규칙 없이 정렬된다고함.
    }

    public static void main(String[] args) {
        HashMapExample proposal = new HashMapExample();
        proposal.solution();
    }

}
