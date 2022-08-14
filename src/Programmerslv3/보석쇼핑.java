package Programmerslv3;

import java.util.*;
public class 보석쇼핑 {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> allkinds = new HashSet<>();
        Collections.addAll(allkinds, gems);
        int start = 0; int last = 0; int dis = Integer.MAX_VALUE;
        Map<String, Integer> term = new HashMap<>();
        int jew_size = allkinds.size();
        while(start<= last){
            if(term.size() == jew_size){
                if(last - start < dis){
                    answer[0] = start+1; answer[1] = last; dis = last - start;
                }
                int v = term.get(gems[start]);
                if(v ==1){
                    term.remove(gems[start]);
                }else{
                    term.put(gems[start], v-1);
                }
                start++;
            }else{
                if(last> gems.length-1){
                    break;
                }
                if(term.containsKey(gems[last])){
                    int v = term.get(gems[last]);
                    term.put(gems[last], v+1);
                }else{
                    term.put(gems[last],1);
                }
                last++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
    }

}
