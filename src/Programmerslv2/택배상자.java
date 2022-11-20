package Programmerslv2;

import java.util.*;
public class 택배상자 {
    public static int solution(int[] order) {
        Stack<Integer> container = new Stack<>();
        int cnt = 1; int idx = 0; int answer = 0;
        while(true){
            if(!container.isEmpty() && order[idx] == container.peek()){
                answer++; idx++; container.pop();
                continue;
            }
            if(cnt > order.length){
                break;
            }
            if(order[idx] == cnt){
                cnt++;
                answer++;
                idx++;
                continue;
            }
            container.push(cnt);
            cnt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] order = {4,3,1,2,5};
        System.out.println(solution(order));
    }
}
