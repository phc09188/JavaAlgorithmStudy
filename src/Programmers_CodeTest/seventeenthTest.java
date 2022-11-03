package Programmers_CodeTest;

import java.util.*;

public class seventeenthTest {
    public int solution(int[] nums) {
        int first = nums[0]; int secound = 0; int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= first){
                int temp = first;
                first = nums[i];
                secound = temp;
            }
        }
        return (first-1) * (secound-1);
    }
    static class M{
        int mine;
        int yours;

        public M(int mine, int yours) {
            this.mine = mine;
            this.yours = yours;
        }
    }


    public int[][] solution(int M, int N, int[][] shapes, int[] colors) {
        int[][] answer = new int[M][N];
        for (int k = 0; k < colors.length; k++) {
            int x = shapes[k][0]; int y = shapes[k][1]; int l = shapes[k][2];
            for (int i = y-l; i <= y+l; i++) {
                for (int j = x-l; j <= x+l; j++) {
                    if(i>=0 && j>=0 && i<M && j<N) {
                        int nx = Math.abs(j - x);
                        int ny = Math.abs(i - y);
                        double len = Math.sqrt(Math.pow(nx, 2) + Math.pow(ny, 2));
                        if (len >= l + 1) {
                            continue;
                        } else {
                            answer[i][j] = Math.max(answer[i][j],colors[k]);
                        }
                    }
                }

            }
        }
        return answer;
    }

    public int solution(int dest, int start, int[] station, int[] fuel) {
        int cnt = 0; int cur = 0;
        if(start > dest){
            return 0;
        }
        while(cur+start < dest){
            int maxidx = 0;
            if(cur+start < dest){
                for (int i = 0; i < station.length; i++) {
                    if(station[i] >cur &&station[i] <= cur+start){
                        if(fuel[maxidx] <=fuel[i]){
                            maxidx = i;
                        }
                    }
                }
            }
            cnt++;
            cur = cur + fuel[maxidx];
        }
        return cnt;
    }

    public static void main(String[] args) {
        seventeenthTest a = new seventeenthTest();
        int[] nums = {1, 1, 1, 1, 1, 1, 3, 4, 4, 5, 2, 3, 4, 6, 6};
        System.out.println(a.solution(nums));
        int[][] values = {{5,3},{6,9},{4,5},{6,3},{2,8},{5,4}};

        int[][] shapes = {{5,4,3},{8,5,4}};
        int[] colors = {50,200};
        System.out.println(Arrays.deepToString(a.solution(10,15,shapes,colors)));
        int[] station = {2,3,5,10};
        int[] fuel = {5,2,3,1};
        System.out.println(a.solution(12,6,station,fuel));
    }
}
