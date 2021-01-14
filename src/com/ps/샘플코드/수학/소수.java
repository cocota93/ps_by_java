package com.ps.샘플코드.수학;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수 {

    /*
    * 소수가 아니라는건 다른수를 조합하여 만들어질수 있는수라는말.
    * 때문에 소수가 아닌수로 나누어보나 소수가 아닌수를 이루는 더 작은수를 이용하여 나누나 소수판별의 결과는 똑같다. 나누었을때 몫이 조금 다를뿐
    * 결국 입력받은수보다 작은수의 소수로만 나누어보면 소수인지 판단가능
    * */

    public void solution(int input) {

        List<Integer> primeList = new ArrayList<>();

        for(int i = 2; i <= input; ++i){
            int target = i;
            boolean isPrime = primeList.stream()
                    .allMatch(prime -> target % prime != 0);

            if(isPrime){
                primeList.add(target);
            }
        }

        primeList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        소수 proposal = new 소수();

        proposal.solution(100);
    }

}
