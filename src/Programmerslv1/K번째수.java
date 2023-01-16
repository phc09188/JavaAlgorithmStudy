package Programmerslv1;

import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int curAnswer = 0;
        for (int i = 0; i < commands.length; i++) {
            int[] sub = new int[commands[i][1] - commands[i][0] + 1];
            int cur = 0;
            for (int j = commands[i][0]-1; j < commands[i][1]; j++) {
                sub[cur++] = array[j];
            }
            Arrays.sort(sub);
            answer[curAnswer++] = sub[commands[i][2]-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        K번째수 a = new K번째수();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        System.out.println(a.solution(array,commands));
    }
}
