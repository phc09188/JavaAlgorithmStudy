package Programmerslv1;

import java.util.*;

public class 숫자짝꿍 {
    public String solution(String X, String Y) {
        String answer = "";
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < X.length(); i++) {
            map.put(X.charAt(i)-'0',map.getOrDefault(X.charAt(i)-'0',0)+1);
        }
        for (int i = 0; i < Y.length(); i++) {
            if(map.containsKey(Y.charAt(i)-'0')){
                list.add(Y.charAt(i)-'0');
                if(map.get(Y.charAt(i)-'0') == 1){
                    map.remove(Y.charAt(i)-'0');
                }else{
                    map.put(Y.charAt(i)-'0', map.get(X.charAt(i)-'0')-1);
                }
            }
        }
        if(list.size()==0){
            return "-1";
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        return answer;
    }
}
