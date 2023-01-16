package Programmerslv1;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            if(budget <=0){
                break;
            }else if(d[i] <= budget){
                budget -= d[i];
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        예산 a = new 예산();
        int[] arr = {1,3,2,5,4};
        System.out.println(a.solution(arr,9));
    }
}
