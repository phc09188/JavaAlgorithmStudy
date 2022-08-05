package Programmerslv2;

import java.io.*;
public class 타겟넘버 {
    int cnt = 0;
    public  int solution(int[] numbers, int target) {
        dfs(numbers,0,target, 0);
        int answer = this.cnt;

        return answer;
    }
    public void dfs(int[] numbers, int depth, int target, int result){
        if(depth == numbers.length) {
            if (target == result) {
                this.cnt += 1;
            }
            return;
        }
        int plus = result + numbers[depth];
        int minus = result - numbers[depth];
        dfs(numbers,depth+1,target, plus);
        dfs(numbers, depth+1, target, minus);
    }
    public static void main(String[] args){
        int[] numbers = {1,1,1,1,1};
        int[] numbers2 = {4,1,2,1};
        타겟넘버 a = new 타겟넘버();
        System.out.println(a.solution(numbers,3));
        System.out.println(a.solution(numbers2, 4));

    }
}
