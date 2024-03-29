package Programmerslv1;

import java.util.ArrayList;
import java.util.HashMap;

public class 개인정보수집유효기간 {
    private static int[] addDays(int year,int month, int day,int term) {
        int[] days = new int[3];
        days[0] = year+(month+term)/12;
        days[1] = (month+term)%12;
        days[2] = day;
        if(day == 0) {
            days[1] -=1;
            days[2] = 28;
        }
        if(days[1] == 0) {
            days[0]-=1;
            days[1] = 12;
        }
        return days;
    }

    private static boolean isLonnger(int[] A,int[] B) {
        for(int i = 0; i < 3; i++) {
            if(A[i] < B[i]) {
                return true;
            }else if(A[i] > B[i]) {
                return false;
            }
        }
        return false;
    }

    private static int[] transDayToInt(String day) {
        int[] answer = new int[3];
        String[] days = day.split("[.]");
        for(int i = 0; i < 3; i++) {
            answer[i] = Integer.parseInt(days[i]);
        }
        return answer;
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < terms.length; i++) {
            String[] cur = terms[i].split(" ");
            map.put(cur[0], Integer.parseInt(cur[1]));
        }

        int[] todays = transDayToInt(today);

        for(int i = 0; i < privacies.length; i++) {
            String[] cur = privacies[i].split(" ");
            int[] day = transDayToInt(cur[0]);
            int[] curDay = addDays(day[0],day[1],day[2]-1,map.get(cur[1]));

            if(isLonnger(curDay,todays)) {
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}