package Programmerslv1;

import java.util.*;
public class 신규아이디추천 {
    public static String solution(String new_id) {
        String step1 = new_id.toLowerCase();
        char[] arr = step1.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] >= '0' && arr[i]<= '9') || (arr[i]>='a' && arr[i]<='z') || arr[i] == '-' || arr[i] == '_' || arr[i] == '.'){
                sb.append(arr[i]);
            }
        }
        String step3 = sb.toString().replace("..", ".");
        while(step3.contains("..")){
            step3 = step3.replace("..",".");
        }
        String step4 = step3;
        if (step4.length() > 0) {
            if (step4.charAt(0) == '.') {
                step4 = step4.substring(1, step4.length());
            }
        }
        if (step4.length() > 0) {
            if (step4.charAt(step4.length() - 1) == '.') {
                step4 = step4.substring(0, step4.length() - 1);
            }
        }

        String step5 = step4;
        if(step5.equals("")){
            step5 = "a";
        }
        String step6 = step5;
        if(step4.length() >=16){
            step6 = step4.substring(0,15);
            if(step6.charAt(14) == '.'){
                step6 = step4.substring(0,14);
            }
        }
        if(step6.length()<=2 && step6.length() != 0){
            char a = step6.charAt(step6.length()-1);
            while(step6.length()<3){
                step6 += a;
            }
        }
        return step6;
    }
    public static void main(String[] args){
        System.out.println(solution("123_.def"));
    }
}
