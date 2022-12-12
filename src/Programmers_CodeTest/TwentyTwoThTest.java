package Programmers_CodeTest;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwentyTwoThTest {
    //1
    public int solution(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        int i, j, max = 0;
        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }
    //2
    public int[][] solution(int[][] s, int[][] t) {
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        for(int[] i : s){
            int a = i[0]; int b = i[1];
            for (int j = 0; j < b; j++) {
                aList.add(a);
            }
        }
        for(int[] i : t){
            int a = i[0]; int b = i[1];
            for (int j = 0; j < b; j++) {
                bList.add(a);
            }
        }
        int[] arr = new int[aList.size()];
        int cur = -1; int cnt = 0;
        for (int i = 0; i < aList.size(); i++) {
            arr[i] =  aList.get(i) * bList.get(i);
            if(cur != arr[i]){
                cur = arr[i];
                cnt++;
            }
        }
        int[][] result = new int[cnt][2]; cur = arr[0]; cnt = 0; int k =0; int i =0;
        while(i<arr.length){
            while(i < arr.length &&arr[i] ==cur){
                i++;
                cnt++;
            }
            result[k][0] = cur; result[k][1] = cnt;
            cnt = 0;
            if(i < arr.length) {
                cur = arr[i];
                k++;
            }
        }
        return result;
    }

    

    public static void main(String[] args) {
        TwentyTwoThTest a = new TwentyTwoThTest();
        int[] nums = {6, 2, 4, 6, 11, 9, 9, 10};
        System.out.println(a.solution(nums));
        int[][] s = {{1,3},{1,4}};
        int[][] t = {{5,2},{3,2},{2,3}};
        System.out.println(Arrays.deepToString(a.solution(s,t)));

    }
}
