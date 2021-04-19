package com.ps.백준.그리디.에너지드링크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그리디/에너지드링크/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //

        int n = Integer.parseInt(br.readLine());
        Double bottle[] = new Double[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < bottle.length; i++) {
            bottle[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(bottle, Comparator.reverseOrder());


        double sum = bottle[0];
        for (int i = 1; i < bottle.length; i++) {
            sum += bottle[i] / 2;
//            System.out.println(sum);
        }

//        DecimalFormat df = new DecimalFormat("0.00000");
        DecimalFormat df = new DecimalFormat("#.#####");
        System.out.println(df.format(sum));


    }

}
