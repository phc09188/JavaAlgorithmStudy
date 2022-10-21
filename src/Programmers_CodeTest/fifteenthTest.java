package Programmers_CodeTest;

import java.util.*;
public class fifteenthTest {
    //1
    public boolean solution(String s) {
        if(s.length()<6 ||s.length()>20) return false;
        boolean small = false; boolean big = false; boolean num = false; boolean special = false;
        String example = "!@#$%^&*()";
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
            if(s.charAt(i) >='A' && s.charAt(i)<='Z') big = true;
            if(s.charAt(i)>='a' && s.charAt(i) <='z') small = true;
            if(s.charAt(i) >='0' && s.charAt(i) <='9') num = true;
            if(example.contains(s.charAt(i)+"")) special = true;
        }
        if(big && small && num && special) {
            for (int i = 0; i <arr.length-2; i++) {
                if(arr[i]+1 == arr[i+1] && arr[i+1] +1 == arr[i+2])return false;
            }
            return true;
        }
        return false;
    }
    //2
    public int solution(int[] arr, int k) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=0) {
                answer += arr[i];

            }else{
                boolean isTrue = false;
                int max = Integer.MIN_VALUE; int maxidx = 0; int l = i+k;
                if(i+k >= arr.length) l = arr.length;
                for (int j = i; j < l; j++) {
                    if(arr[j] >=0){
                        i = j;
                        answer+=arr[i];
                        isTrue = true;
                        break;
                    }else{
                        if(max <= arr[j]){
                            max = arr[j];
                            maxidx = j;
                        }
                    }
                }
                if(!isTrue) {
                    i =maxidx;
                    answer += arr[maxidx];
                }
            }
        }
        return answer;
    }
    static int a = 0;
    public int solution3(int[] buckets, int m) {
        boolean[] visited = new boolean[buckets.length];
        combination(buckets,visited,0,buckets.length,m);
        return a;
    }
    void combination(int[] arr, boolean[] visited, int depth, int n, int r){
        if(r == 0){
            String in = "";
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    in += arr[i] +" ";
                }
            }
            String[] input = in.split(" ");
            int start = Integer.parseInt(input[1]) - Integer.parseInt(input[0]); int sum= start;
            boolean isTrue = true;
            for (int i = 1; i < input.length-1; i++) {
                if((Integer.parseInt(input[i+1]) - Integer.parseInt(input[i])) == start){
                }else{
                    isTrue = false;
                    return;
                }
            }
            a = Math.max(a, sum);
            return;
        }
        if(depth ==n){
            return;
        }
        visited[depth] = true;
        combination(arr, visited, depth+1, n, r-1);
        visited[depth] = false;
        combination(arr, visited, depth+1, n, r);
    }
    //4
    public int solution(int[] numsDivide, int[] numsDivided) {
        int answer = 0;
        Arrays.sort(numsDivide);
        HashSet<Integer> delNum = new HashSet<>();
        if(numsDivide[0] ==1){
            return 0;
        }
        for (int i = 0; i < numsDivide.length; i++) {
            boolean isTrue = true;
            if(!delNum.contains(numsDivide[i])) {
                for (int j = 0; j < numsDivided.length; j++) {
                    if (numsDivided[j] % numsDivide[i] != 0) {
                        isTrue = false;
                        break;
                    }
                }
                if (!isTrue) {
                    answer++;
                    delNum.add(numsDivide[i]);
                }
                if(isTrue){
                    return answer;
                }
            }else{
                answer++;
            }
        }
        return 0;
    }
    //5
    public int solution(int[] nums) {
        int len = nums.length;
        int n = len/3;
        long diff = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            int[] copy = nums.clone();
            int le = j+n;
            if(le>nums.length) break;
            for (int i = j; i < j+n; i++) {
                copy[i] = 0;
            }
            int cnt = 0; long start = 0; long end = 0; boolean isStart = true;
            for (int i = 0; i < nums.length; i++) {
                if(copy[i] != 0){
                    if(isStart){
                        start+=copy[i];
                        cnt++;
                        if(cnt == n){
                            cnt = 0;
                            isStart = false;
                        }
                    }else{
                        end +=copy[i];
                        cnt++;
                        if(cnt ==n){
                            diff = Math.min(diff, start- end);
                            break;
                        }
                    }
                }
            }
        }
        return (int)diff;
    }
    public static void main(String[] args){
        fifteenthTest a = new fifteenthTest();
        System.out.println(a.solution("zeRobAsE!2#4"));

        int[] arr = {1,-1,-20,4,-7,5};
        System.out.println(a.solution(arr,2));

        int[] numDivide = {100,101,102,103,104,105,106}; int[] numDivided = {9,18,27,9,15};
        System.out.println(a.solution(numDivide,numDivided));
        int[] bucket = {1,2,4,9,99999};
        System.out.println(a.solution3(bucket,2));
        int[] nums = {7,9,5,8,1,3};
        System.out.println(a.solution(nums));

    }
}
