package Programmerslv2;

import java.io.*;
import java.util.*;

public class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[progresses.length];
        Queue<Integer> qu = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            if((100 -progresses[i])% speeds[i] ==0){
                arr[i] = (100 -progresses[i])/speeds[i];
                qu.add(arr[i]);
            }else{
                arr[i] = (100 -progresses[i])/speeds[i] +1;
                qu.add(arr[i]);
            }
        }
        boolean[] visited = new boolean[progresses.length];
        int idx = 0;
        while(!visited[visited.length-1]){
            int cnt = 0;
            for (int i = idx; i < arr.length; i++) {
                arr[i] -=1;
            }
            if(arr[idx] ==0){
                for (int i = idx; i < arr.length; i++) {
                    if(arr[i]<=0){
                        idx++;
                        cnt++;
                        visited[i] = true;
                    }else{
                        break;
                    }
                }

            }
            if(cnt!= 0) {
                list.add(cnt);
            }
        }

        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        int[] progresses1 = {93, 30, 55};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds1 = {1, 30, 5};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        //System.out.println(Arrays.toString(solution(progresses1, speeds1)));
        System.out.println(Arrays.toString(solution(progresses2, speeds2)));
    }
}
