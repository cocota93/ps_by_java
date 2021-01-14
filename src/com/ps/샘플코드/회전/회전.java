package com.ps.샘플코드.회전;

public class 회전 {


    public int solution(int[] input, int moveCount, boolean directionForward) {
        int result = 0;
        if(directionForward == true){
            result = input[moveCount % input.length];
        }else{
            //moveCount만큼 앞으로 가는게 n - moveCount만큼 뒤로 가는것과 동일
            int fixedMoveCount = input.length - (Math.abs(moveCount) % input.length);
            int i = fixedMoveCount % input.length;
            result = input[i];
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        회전 proposal = new 회전();

        int input[] = {1, 2, 3, 4};
        proposal.solution(input, 0, true);
        proposal.solution(input, 1, true);
        proposal.solution(input, 2, true);
        proposal.solution(input, 3, true);
        proposal.solution(input, 4, true);
        proposal.solution(input, 5, true);
        proposal.solution(input, 10,true);

        System.out.println("");
        proposal.solution(input, 0, false);
        proposal.solution(input, 1, false);
        proposal.solution(input, 2, false);
        proposal.solution(input, 3, false);
        proposal.solution(input, 4, false);
        proposal.solution(input, 5, false);
        proposal.solution(input, 10,false);
    }

}
