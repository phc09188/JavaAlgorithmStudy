package Programmerslv1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])){
                int v = map.get(participant[i]);
                map.put(participant[i], v+1);
            }else{
                map.put(participant[i], 1);
            }
        }
        for (int i = 0; i < completion.length; i++) {
            if(map.containsKey(completion[i])){
                int v = map.get(completion[i]);
                if(v ==1){
                    map.remove(completion[i]);
                }else{
                    map.put(completion[i], v-1);
                }
            }
        }
        String answer = "";
        for(Map.Entry<String,Integer> list : map.entrySet()){
            answer = list.getKey();
        }

        return answer;
    }
    public static void main(String[] args){
        String[] participant ={"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
