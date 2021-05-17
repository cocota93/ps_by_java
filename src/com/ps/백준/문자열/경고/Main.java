package com.ps.백준.문자열.경고;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.SECONDS;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/경고/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        LocalTime nowTime = LocalTime.parse(br.readLine(), DateTimeFormatter.ISO_TIME);
        LocalTime explosionTime = LocalTime.parse(br.readLine(), DateTimeFormatter.ISO_TIME);

        LocalDateTime now = LocalDateTime.of(LocalDate.now(), nowTime);
        LocalDateTime explosionDateTime = LocalDateTime.of(LocalDate.now(), explosionTime);


        if(now.compareTo(explosionDateTime) >= 0){
            //now가 더 클경우
            explosionDateTime = explosionDateTime.plusDays(1);
        }


        long betweenDay = Math.abs(DAYS.between(now, explosionDateTime));
        if(betweenDay > 0){
            System.out.println("24:00:00");
        }else {
            long betweenTime = Math.abs(SECONDS.between(now, explosionDateTime));
            LocalTime diffTime = LocalTime.ofSecondOfDay(betweenTime);
            System.out.println(diffTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }

    }

}
