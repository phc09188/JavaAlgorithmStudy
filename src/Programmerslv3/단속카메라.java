package Programmerslv3;

import java.util.*;
public class 단속카메라 {
    public static int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cam = Integer.MIN_VALUE;
        for(int[] route : routes){
            if(cam < route[0]){
                cam = route[1];
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};
        System.out.println(solution(routes));
    }
}
