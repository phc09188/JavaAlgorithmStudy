package Programmers_CodeTest;

import java.io.*;
import java.util.*;
public class thirdTest {
    static int max = 0;
    public static int solution1(int N, int[][] trust){
        int answer =0;
        int[] people = new int[trust.length];
        int[] direction = new int[N+1];
        boolean isTrue =true;
        for (int i = 0; i < trust.length; i++) {
            people[i] = trust[i][0];
            direction[trust[i][1]] += 1;
        }
        for (int i = 0; i < direction.length; i++) {
            max = Math.max(max, direction[i]);
        }
        if(max == N-1) {
            for (int i = 0; i < direction.length; i++) {
                isTrue = false;
                if (direction[i] == max) {
                    for (int j = 0; j < people.length; j++) {
                        if (people[j] == i) {
                            return -1;
                        } else {
                            isTrue = true;
                        }
                    }
                    answer = i;
                    break;
                }
            }
            if (isTrue) {
                return answer;
            } else {
                return -1;
            }
        }else{
            return -1;
        }
    }
    static int min = Integer.MAX_VALUE;
    public static boolean is(int a){
        boolean[] isTrue = new boolean[1000001];

        for (int i = 2; i < Math.sqrt(a); i++) {
            if(isTrue[i] == true){
                continue;
            }
            for (int j = i*i; j < isTrue.length; j = j+i) {
                isTrue[j] = true;
            }
        }
        if(isTrue[a]){
            return false;
        }else{
            return true;
        }
    }
    public static int solution2(int[] numbers, int target){
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == target){
                return 1;
            }
        }
        boolean istrue2 = true;
        istrue2 = is(target);
        if(!istrue2) {
            for (int i = 0; i < target / 2; i++) {
                min = Math.min(min, solution2(numbers, i) + solution2(numbers, target - i));
            }
        }else{
            for (int i = 0; i < target / 2; i++) {
                min = Math.min(min, solution2(numbers, i) + solution2(numbers, target - i));
            }
            for (int i = 0; i < Math.sqrt(target); i++) {
                if(target%i == 0){
                    min = Math.min(min, solution2(numbers, i) * solution2(numbers, target - i));
                }
            }
        }
        return min;
    }
    public static int solution3(int delay, int N){
        if(N<0){
            return 0;
        }
        if(N==0){
            return 1;
        }
        else if(N ==1){
            return 3;
        }else if(N==2){
            return 5;
        }
        return solution3(delay,N-1) + solution3(delay, N-1-delay)+1;
    }
    public static int solution4(int x1, int y1, int x2, int y2) {
        int answer = 0;
        int xcut = Math.abs(x2-x1);
        int ycut = Math.abs(y2-y1);
        while(true) {
            if (x2 > x1 && y2 > y1) {
                if (xcut > ycut) {
                    y1 += 1;
                    x2 -= 1;
                    y2 -= 1;
                } else if (xcut < ycut) {
                    x1 += 1;
                    x2 -= 1;
                    y2 -= 1;
                }
            } else if (x2 > x1 && y2 < y1) {
                if (xcut > ycut) {
                    x1 += 1;
                    x2 -= 1;
                    y2 += 1;
                } else if (xcut < ycut) {
                    y1 -= 1;
                    x2 -= 1;
                    y2 += 1;
                }
            } else if (x2 < x1 && y2 < y1) {
                if (xcut > ycut) {
                    x1 -= 1;
                    x2 += 1;
                    y2 += 1;
                } else if (xcut < ycut) {
                    y1 -= 1;
                    x2 += 1;
                    y2 += 1;
                }
            } else if (x2 < x1 && y2 > y1) {
                if (xcut > ycut) {
                    x1 -= 1;
                    x2 += 1;
                    y2 -= 1;
                } else if (xcut < ycut) {
                    y1 += 1;
                    x2 += 1;
                    y2 -= 1;
                }
            }else if(x2 == x1 && (y1-y2) >=1){
                x1+=1; x2+=1; y2+=1;
            }else if(x2 == x1 && (y2-y1) >=1){
                x1+=1; x2+=1; y2-=1;
            }else if((x2-x1)>=1 && y2>y1){
                y1+=1; y2+=1; x2-=1;
            }else if((x1-x2) >= 1 && y2>y1){
                x2+=1; y2+=1; y1+=1;
            }
            answer++;
            if(x2==x1 && y2==y1){
                break;
            }
        }
        return answer;
    }
//    static boolean[] kill;
//    public static int stage(int[] reward, int[] health, boolean[] kill){
//        int attack = 1;
//        int answer =0;
//        for (int i = 0; i < kill.length; i++) {
//            while(kill[i] && health[i] >0){
//                health[i] -=1;
//                answer +=1;
//            }
//            if(health[i] <=0 &&kill[i]){
//                attack += reward[i];
//            }
//        }
//        return answer;
//    }
//    public static boolean[] combination(int[] arr, boolean[] visited, int depth, int n, int r, boolean[] kill){
//        if(r == 0){
//            for (int i = 0; i < n; i++) {
//                if (visited[i]) {
//                    kill[arr[i]] = true;
//                }
//            }
//            return kill;
//        }
//        if(depth ==n){
//            return kill;
//        }
//        visited[depth] = true;
//        combination(arr, visited, depth+1, n, r-1, kill);
//        visited[depth] = false;
//        combination(arr, visited, depth+1, n, r, kill);
//        return kill;
//    }
//
//    public static int solution5(int[] reward, int[] health, int[] optional) {
//        int N = optional.length;
//        boolean[] kill = new boolean[optional.length];
//        int cnt = 0;
//        List<Integer> a = new ArrayList();
//        for (int i = 0; i < N; i++) {
//            if(optional[i] ==1){
//                kill[i] = true;
//            }else{
//                a.add(i);
//                cnt++;
//            }
//        }
//        int[] arr = new int[cnt];
//        for (int i = 0; i < a.size(); i++) {
//            arr[i] = a.get(i);
//        }
//        boolean[] visited2 = new boolean[arr.length];
//        min = Math.min(stage(reward,health,kill), min);
//        for (int i = 1; i < cnt; i++) {
//            boolean[] visited = new boolean[arr.length];
//            min = Math.min(stage(reward,health,combination(arr, visited, 0, cnt, i, kill)), min);
//
//        }
//        return min;
//    }

    public static void main(String[] args) throws IOException{
        int[][] trust = {{1,3},{2,3}};
        int[][] trust2 = {{1,2}, {1,4}, {1,3}, {2,1},{4,3}};
        //System.out.println(solution1(3, trust));
        //System.out.println(solution1(4,trust2));
        int[] numbers = {1,4,2};
        System.out.println(solution2(numbers,12));
//        System.out.println(solution3(1,2));
//        System.out.println(solution3(2, 5));
        //System.out.println(solution4(2,4,5,-3));
//        int[] reward = {4,2,2,0,3,5};
//        int[] health = {10,20,20,20,40,30};
//        int[] optional ={1,0,1,0,0,0};
//        System.out.println(solution5(reward,health,optional));
        System.out.println(solution2(numbers, 12));
    }
}
