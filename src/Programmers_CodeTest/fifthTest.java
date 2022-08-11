package Programmers_CodeTest;

import java.util.*;
public class fifthTest {
    public static boolean solution1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> X = new HashMap<>();
        for (char c : s.toCharArray()) {
            X.put(c, X.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> Y = new HashMap<>();
        for (char c : t.toCharArray()) {
            Y.put(c, Y.getOrDefault(c, 0) + 1);
        }
        return X.equals(Y);
    }
    public static String solution2(int[] numbers) {
        String answer = "";
        boolean except = true;
        String[] num = new String[numbers.length];

        for(int i = 0; i < num.length; i++){
            num[i] = String.valueOf(numbers[i]);
            if(numbers[i] != 0) except = false;
        }

        Arrays.sort(num, new Comparator<String>(){
            @Override
            public int compare(String n1, String n2) {
                return (n2+n1).compareTo(n1+n2);
            }
        });
        for(int i = 0; i < num.length; i++)
            answer += num[i];
        if(except) answer = "0";
        return answer;
    }
    public static int find(int[] arr, int left, int right){
        int mid = (left + right)/2;

        while(left <= right){
            if(mid != 0 && mid != arr.length-1 && arr[mid-1] <=arr[mid] && arr[mid+1]<=arr[mid] ){
                return mid;
            }
            if(mid - 1 >= 0 && arr[mid - 1] > arr[mid] && mid != 0){
                right = mid-1;
            }else{
                left = mid +1;
            }
            mid = (left+ right)/2;
        }
        return -1;
    }
    public static int solution3(int[] arr) {
        if (arr.length == 0 || arr == null) {
            System.out.println(-1);
        } else {
            int idx = find(arr, 0, arr.length - 1);
            return idx;
        }
        return -1;
    }
    public static int solution4(int n, int[] branches) {
        long left = 0;
        long result=0;
        long right = 0;
        for (int i = 0; i < branches.length; i++) {
            right = Math.max(right, branches[i]);
            result += branches[i];
        }
        if(n > result){
            return -1;
        }
        while(left<= right){
            long mid = (left + right)/2;
            long sum = 0;
            for (int i = 0; i < branches.length; i++) {
                sum += branches[i]/mid;
            }
            if(n<=sum){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return (int) right;
    }
    public static int solution5(int N, int M, int[] fry, int[] clean) {
        long answer = 0;
        long left = 0;
        int max = 0;
        int[] arr = new int[fry.length];
        for (int i = 0; i < fry.length; i++) {
            arr[i] = fry[i] + clean[i];
            max = Math.max(arr[i],max);
        }
        long right = max * M;
        while(left<= right){
            long mid = (left + right)/2;
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += mid/arr[i];
                if(mid%arr[i]>= fry[i]) sum++;
            }
            if(sum <M){
                left = mid +1;
            }else{
                right = mid -1;
                answer = mid;
            }
        }
        return (int)answer;
    }
    public static void main(String[] args){
        System.out.println(solution1("imfinethankyou", "atfhinemnoyuki"));
        int[] numbers = {3,30, 34, 5, 9};
        System.out.println(solution2(numbers));
        int[] arr = {-3,0,3,4,5,12,15,14,12,11};
        int[] arr2 = {-5,4,6,12,16,17};
        System.out.println(solution3(arr));
        System.out.println(solution3(arr2));
        int[] branches = {6,7,10,16,12};
        System.out.println(solution4(10,branches));
        System.out.println(solution4(10,branches));
        int[] fry ={3,6};
        int[] clean = {2,1};
        System.out.println(solution5(2,20,fry, clean));
    }
}
