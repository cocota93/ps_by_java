package com.ps.인프런.stringarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueEmailAddress {


    public String[] solution(String[] input) {
        Set<String> result = new HashSet<>();

        for (int i = 0; i < input.length; ++i) {
            String s = input[i];

            StringBuilder nameBuilder = new StringBuilder();
            for (Character character : s.toCharArray()) {
                if(character == '.'){
                    continue;
                }

                if(character == '+'){
                    break;
                }

                if(character == '@'){
                    break;
                }

                nameBuilder.append(character);
            }
            String name = nameBuilder.toString();


            int separateTokenIndex = s.indexOf("@");
            String domain = s.substring(separateTokenIndex, s.length());

            result.add(name + domain);
        }

        String resultArray[] = new String[result.size()];

        return result.toArray(resultArray);
    }
//    public String[] solution(String[] input) {
//        Set<String> result = new HashSet<>();
//
//        for (int i = 0; i < input.length; ++i) {
//            String s = input[i];
//            int separateTokenIndex = s.indexOf("@");
//            String name = s.substring(0, separateTokenIndex);
//            if(name.contains("+")){
//                name = name.substring(0,name.indexOf("+"));
//            }
//            name = name.replace(".", "");
//            String domain = s.substring(separateTokenIndex, s.length());
//
//            result.add(name + domain);
//        }
//
//        String resultArray[] = new String[result.size()];
//
//        return result.toArray(resultArray);
//    }

    public static void main(String[] args) {
        UniqueEmailAddress proposal = new UniqueEmailAddress();

        String input[] = {"test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"};
        String[] solution = proposal.solution(input);
        System.out.println(Arrays.toString(solution));
    }

}
