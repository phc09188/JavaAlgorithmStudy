package Programmers_CodeTest;


import java.io.*;
import java.util.*;
public class SecondTest {
    public static int solution1(int[] numbers){
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < numbers.length; i++) {
            arr.add(numbers[i]);
        }
        Collections.sort(arr);
        int min = arr.get(0);
        int i = 1;
        boolean isTrue = false;
        while(i<arr.size()){
            if(arr.get(i) != min+i){
                answer = min +i;
                break;
            }else {
                i++;
            }
        }
        if(isTrue) {
            return answer;
        }else{
            return -1;
        }
    }
    public static int[] solution2(int[] a, int[] b){
        int[] answer = {};



        return answer;
    }
    public static String solution3(String code){
        String answer = "";
        String temp = "";
        char[] arr = code.toCharArray();
        Stack<Integer> IntegerStack = new Stack();
        Stack<Character> Stringstack = new Stack<>();
        for (int i = 0; i < code.length(); i++) {
            int cnt = 0;
            if (arr[i] >= '0' && arr[i] <= '9') {
                while (arr[i] >= '0' && arr[i] <= '9') {
                    cnt = cnt * 10 + arr[i] - '0';
                    i++;
                }
                i--;
                IntegerStack.push(cnt);
            } else if (arr[i] == '{') {
                if (arr[i - 1] >= '0' && arr[i - 1] <= '9') {
                    Stringstack.push(arr[i]);
                } else {
                    Stringstack.push(arr[i]);
                    IntegerStack.push(1);
                }
            } else if (arr[i] == '}') {
                temp = "";
                cnt = 0;
                if (!IntegerStack.empty()) {
                    cnt = IntegerStack.peek();
                    IntegerStack.pop();
                }
                while (!Stringstack.empty() && Stringstack.peek() != '{') {
                    temp = Stringstack.peek() + temp;
                    Stringstack.pop();
                }
                if (!Stringstack.empty() && Stringstack.peek() == '{') {
                    Stringstack.pop();
                }
                for (int j = 0; j < cnt; j++) {
                    answer = answer + temp;
                }
                char[] arr2 = answer.toCharArray();
                for (int j = 0; j < answer.length(); j++) {
                    Stringstack.push(arr2[j]);
                }
                answer = "";
            } else {
                Stringstack.push(arr[i]);
            }
        }
        while(!Stringstack.empty()){
            answer = Stringstack.peek() + answer;
            Stringstack.pop();
        }
        return answer;
    }
    public static int solution(int delay, int capacity, int[] times) {
        Queue qu = new LinkedList();
        int answer = 0;
        int time = 0;
        int cnt = 0;
        while(cnt< times.length){
            if(time == 0 && cnt ==0){
                time += times[cnt];
            }
            else{
                time += times[cnt];
                if(qu.size() < capacity){
                    qu.add(cnt);

                }else{
                    answer++;
                }
            }
            if(time /delay != 0){
                while(time >=delay) {
                    time = time - delay;
                    qu.poll();
                }
            }
            cnt++;
        }
        return answer;
    }
    public static int[][] solution5(int[][] image, int k){
        int n = k/2;
        int[][] answer = new int[image.length][image[0].length];
        int[][] base = new int[image.length+2*n][image[0].length+2*n];
        for (int i = n; i < image.length+1; i++) {
            for (int j = n; j < image.length+1; j++) {
               base[i][j] = image[i-n][j-n];
            }
        }
        int row = 0;
        int col = 0;

        while(row != image.length && col != image.length){
            int count = 0;
            for (int i = row; i < row+k; i++) {
                for (int j = col; j < col+k; j++) {
                    count += base[i][j];
                }
            }
            if(row == image.length && col == image.length){
                break;
            }else if(col == image.length-1){
                answer[row][col] = count/(k*k);
                col = 0;
                row++;
            }else{
                answer[row][col] = count/(k*k);
                col++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] numbers = {9,4,2,3,7,5};
//        int[] a = {5,2,1,4,6};
//        int[] b = {6,1,0,4,4};
//        String code = "5{he2{l}o}friend";
//        //System.out.println(solution1(numbers));
//        System.out.println(Arrays.toString(solution2(a, b)));
//        System.out.println(solution3(code));
        int[] arr = {3,2,0,0,2,3,0,0,2,2,5};
        int[] arr2 = {2, 2, 0, 4, 2, 3, 0, 0, 1, 2, 5, 0, 3, 4, 0};
        //System.out.println(solution(5,5,arr));
        //System.out.println(solution(3,5, arr2));
        int[][] arr3 = {{4,5,2,6,7}, {5,4,2,4,6}, {6,8,4,8,7}, {7,3,6,6,4}, {5,0,4,1,5}};
        System.out.println(Arrays.deepToString(solution5(arr3, 3)));
    }
}
