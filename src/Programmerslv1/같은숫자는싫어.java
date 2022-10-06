package Programmerslv1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 같은숫자는싫어 {
    public static  int[] solution(int []arr) {
        Queue<Integer> set = new LinkedList<>();
        set.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]){
                set.add(arr[i]);
            }
        }
        int a = set.size();
        int[] answer = new int[a];
        for (int i = 0; i < a; i++) {
            answer[i] = set.poll();
        }
        return answer;
    }
    public static void main(String[] args){
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
