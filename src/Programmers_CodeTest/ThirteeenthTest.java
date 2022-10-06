package Programmers_CodeTest;

import java.util.*;
import java.io.*;


public class ThirteeenthTest {
    public static int solution(String s) {
        int max = Integer.MAX_VALUE;
        char[] arr = s.toCharArray();
        boolean isMinus = true;
        boolean visited = false;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(!visited&&(arr[i] == '+' || arr[i] == '-')){
                if(arr[i] == '+') isMinus = false;
                else if(arr[i]== '-') isMinus = true;
                if(arr[i+1] <=48 || arr[i+1] >57){
                    i +=2;
                }else{
                    i +=1;
                }
                while(arr[i] == 48){
                    i++;
                }
                while(i<arr.length && arr[i] >=48 && arr[i]<=57 ){
                    stack.add(arr[i] -48);
                    visited = true;
                    i++;
                }
                if(visited) break;
            }
        }
        long answer = 0;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            answer += stack.pop() * (int)Math.pow(10, i);
            if(answer > max){
                if(isMinus){
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
        }
        if(isMinus){
            answer *= (-1);
        }
        return (int)answer;
    }
    static int cur = 10000000;
    static int answer = 10000000;
    public static int solution(int[] arr, int target) {
        boolean[] visited = new boolean[arr.length];
        Arrays.sort(arr);
        combination(arr,visited,0,arr.length,3,target);
        return answer;
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r, int target){
        if (r == 0) {
            int a = 0;
            for (int i = 0; i < n; i++) {
                if(visited[i]){
                    a += arr[i];
                }
            }
            int k = Math.abs(target-a);
            if(k<= cur){
                cur = k;
                answer = a;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if(arr[i] >= target){
                break;
            }
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, target);
            if(cur ==0){
                return;
            }
            visited[i] = false;
        }
    }
    static class Node{
        int to;
        int cnt;

        public Node(int to, int cnt) {
            this.to = to;
            this.cnt = cnt;
        }
    }
    public static int solution(int N, int[][] edges){
        boolean[] visited = new boolean[N+1];
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<Node>());
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(1,0));
        visited[1] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.to == N){
                cnt = cur.cnt +1;
                break;
            }
            for (int i = 0; i < edges[cur.to].length; i++) {
                int temp = edges[cur.to][i];
                if(!visited[temp]){
                    visited[temp] = true;
                    q.offer(new Node(temp, cur.cnt+1));
                }
            }
        }
        int k = cnt/10;
        if(cnt%10 !=0){
            return k+1;
        }
        return k;
    }



    public static void main(String[] args){
//        String num1 = " -233ro + 12345 - 66zero";
//        String num2 = " + 00051241231004242542514243_41251243";
//        System.out.println(solution(num1) + " " + solution(num2));
        int[] arr ={2,3,5,10,12,15};
        System.out.println(solution(arr, 21));
        int[][] edges = {{1,2},{1,3,},{2,4},{2,5},{3,6},{4,7},{5,7},{6,5},{6,8},{7,9},{8,10},{9,10},{10,11},{11,12},{12,13}};
        System.out.println(solution(13,edges));
    }
}
