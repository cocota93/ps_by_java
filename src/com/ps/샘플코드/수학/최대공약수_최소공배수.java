package com.ps.샘플코드.수학;

public class 최대공약수_최소공배수 {

    /*
    * 최대공약수
    * 유클리드 알고리즘 이라고 한다.
    * 큰값을 작은값으로 나누었을때 나머지가 0이 아니라면
    * 작은값을 큰값으로, 나머지를 작은값으로 바꿔서 반복하면 나온다고한다.\
    *
    * 솔직히 잘 이해는 안간다.
    * */
    private static int GCD(int bigNum, int smallNum) {
        System.out.printf("bigNum : %d, smallNum : %d", bigNum, smallNum);
        System.out.println("");
        while(smallNum != 0){
            int temp = bigNum % smallNum;
            bigNum = smallNum;
            smallNum = temp;

            System.out.printf("bigNum : %d, smallNum : %d", bigNum, smallNum);
            System.out.println("");
        }

        System.out.println("gcd : " + bigNum);

        return bigNum;
    }

    /*
    * 최소공배수
    * 최대공약수보다는 좀더 이해 가는것 같지만
    * 역시 명확하게 설명하라하면 자신없다.
    * */
    private static int LCM(int bigNum, int smallNum) {
        int lcm = (bigNum * smallNum) / GCD(bigNum, smallNum);
        System.out.println("LCM : " + lcm);
        return lcm;
    }

    public static void main(String[] args) {
        int bigNum = 36;
        int smallNum = 20;

        int gcd = GCD(bigNum, smallNum);

        int lcm = LCM(bigNum, smallNum);
    }
}
