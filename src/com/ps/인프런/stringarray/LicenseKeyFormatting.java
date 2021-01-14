package com.ps.인프런.stringarray;


public class LicenseKeyFormatting {


    public String solution(String input, int k) {
        String result = "";
        String convertedInput = "";
        convertedInput = input.replaceAll("-", "");
        convertedInput = convertedInput.toUpperCase();

        StringBuilder sb = new StringBuilder(convertedInput);

        for (int i = k; i <= convertedInput.length() ; i = i + k) {
            sb.insert(convertedInput.length() - i, "-");
        }

        result = sb.toString();
        return result;
    }

    public static void main(String[] args) {
        LicenseKeyFormatting proposal = new LicenseKeyFormatting();

//        String input = "8F3Z-2e-9-w";
        String input = "8-5g-3-J";
        int k = 4;
        String result = proposal.solution(input, k);
        System.out.println(result);
    }

}
