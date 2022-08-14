package Programmerslv1;


public class 소수만들기 {
    static int cnt =0;
    public static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    static void combination(int[] arr, boolean[] visited, int depth, int n, int r){
        if(r == 0){
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if(isPrime(sum)) cnt++;
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
    public static int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        combination(nums,visited, 0, nums.length,3);
        int answer = cnt;
        cnt  =0;
        return answer;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int[] nums2 = {1,2,7,6,4};
        System.out.println(solution(nums));
        System.out.println(solution(nums2));
    }
}
