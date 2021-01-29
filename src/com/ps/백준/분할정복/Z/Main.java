package com.ps.백준.분할정복.Z;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
* 시간초과 발생. 중간에 불필요한걸 건너 뛰어야 통과할수 있을듯한데...뭐가 있을려나
* 굳이 다 탐색해보지 않고 수식을 만들어서 구할수 있지 않을까??
* -> 수식으로 만들어볼려고 했지만 잘 안됨. 그리고 이건 분할정복 문제임 ㅡㅡ
* 재귀호출 외에는 별다른 로직도 없는데 시간초과? 그러면 재귀를 쓰면 안된다는 말로 봐야될것같은데...
* 분할하는 방법이 틀린걸까?
*
*
* 예제기준으로 n은 3. 칸수는 64칸. 64칸은 2^6
* */

/*
* 못풀겠어서 풀이를 찾아봤다. 풀이가 제대로 이해되지는 않지만 중요한 포인트만 가져와서 내식대로 짜면 될것같다.
* 익숙하지 않은 유형이라 그렇지 충분히 풀만한 문제인것 같다.
* */

class Main {

    static int sequence = 0;
    static int destR;
    static int destC;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/분할정복/Z/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        destR = Integer.parseInt(st.nextToken());
        destC = Integer.parseInt(st.nextToken());

        int sideLength = (int) Math.pow(2, N);
        int baseRow = 0;
        int baseCol = 0;
        Recur(sideLength, baseRow, baseCol);


//        bw.write("" + sequence);
        bw.flush();
        bw.close();

    }

    private static boolean Recur(int sideLength, int baseRow, int baseCol) {
        if(sideLength == 1){
            if(baseRow == destR && baseCol == destC){
//                System.out.println(sequence);
                return true;
            }

            System.out.println("R : " + baseRow + ", C : " + baseCol + ", sequence : " + sequence);
            sequence++;

            return false;
        }


        int nextSideLength = sideLength / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int relativeRow = baseRow + (i * nextSideLength);
                int relativeCol = baseCol + (j * nextSideLength);
                boolean answerFind = Recur(nextSideLength, relativeRow, relativeCol);
                if(answerFind) return true;
            }
        }

        return false;
    }

}
