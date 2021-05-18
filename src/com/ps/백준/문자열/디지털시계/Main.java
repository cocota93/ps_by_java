package com.ps.백준.문자열.디지털시계;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Formatter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

import static java.time.temporal.ChronoUnit.SECONDS;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/디지털시계/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        ZoneId zoneId = ZoneId.systemDefault();
        ZoneOffset zoneOffset = zoneId.getRules().getOffset(LocalDateTime.now());

        while (true) {
            String testCase = br.readLine();
            if(testCase == null) break;
            st = new StringTokenizer(testCase, " ");

            LocalTime localTimeStart = LocalTime.parse(st.nextToken());
            LocalTime localTimeEnd = LocalTime.parse(st.nextToken());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HHmmss");


            int count = 0;
            while(localTimeStart.compareTo(localTimeEnd) != 0){
                String formatNumber = localTimeStart.format(dateTimeFormatter);
                int formatInteger = Integer.parseInt(formatNumber);

                if(formatInteger % 3 == 0){
                    count++;
                }
                localTimeStart = localTimeStart.plusSeconds(1);
            }

            {
                String formatNumber = localTimeStart.format(dateTimeFormatter);
                int formatInteger = Integer.parseInt(formatNumber);

                if(formatInteger % 3 == 0){
                    count++;
                }
            }

            System.out.println(count);

//            int startSecond = localTimeStart.toSecondOfDay();
//            int endSecond = localTimeEnd.toSecondOfDay();
//            if(startSecond > endSecond){
//
//            }


//            LocalDateTime localDateTimeStart = LocalDateTime.of(LocalDate.now(),localTimeStart);
//            LocalDateTime localDateTimeEnd = LocalDateTime.of(LocalDate.now(),localTimeEnd);
//            if(localDateTimeStart.compareTo(localDateTimeEnd) > 0){
//                System.out.println(localDateTimeEnd.toEpochSecond(zoneOffset));
//                localDateTimeEnd = localDateTimeEnd.plusDays(1);
//                System.out.println(localDateTimeEnd.toEpochSecond(zoneOffset));
//                localDateTimeEnd = localDateTimeEnd.minusSeconds(1);
//                System.out.println(localDateTimeEnd.toEpochSecond(zoneOffset));
//            }
//
//
//
//            long epochStart = localDateTimeStart.toEpochSecond(zoneOffset);
//            long epochEnd = localDateTimeEnd.toEpochSecond(zoneOffset);
//
//            int count = 0;
//            for (int i = (int) epochStart; i <= epochEnd; i++) {
//                if(i % 3 == 0){
//                    count++;
//                }
//            }
//
//            System.out.println(count);



//            long between = Math.abs(SECONDS.between(localDateTimeStart, localDateTimeEnd));
//            System.out.println(between / 3);
        }
    }

}
