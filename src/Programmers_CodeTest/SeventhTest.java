package Programmers_CodeTest;

import java.io.*;
import java.util.*;
public class SeventhTest {
    /*1번
    static int totalsize;
    static String answer = "";
    public static String solution(int[][] arr) {
        totalsize = arr.length;
        dps(0,0,totalsize, arr);
        return answer;
    }
    public static void dps(int startX, int startY, int size, int[][] arr){
        if(check(startX,startY, size, arr)){
            if(size == totalsize){
                answer = "0";
                return;
            }
            int a = arr[startX][startY];
            answer += a;
            return;
        }
        answer += "(";
        dps(startX,startY,size/2, arr);
        dps(startX, startY + size/2, size/2, arr);
        dps(startX+ size/2, startY, size/2, arr);
        dps(startX+size/2, startY+size/2, size/2, arr);
        answer += ")";
    }
    public static boolean check(int x, int y, int size, int[][] arr){
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(arr[x][y] != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }*/
    /*2번
    public static int solution2(int[] votes) {
        int x = 0; int cnt = 0;
        for (int i = 0; i < votes.length; i++) {
            if(cnt == 0){
                x = votes[i];
                cnt++;
            }else if(x == votes[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        return x;
    }*/
    /*3번
    static List<String> list = new ArrayList<>();
    public static String[] solution3(String s) {
        dfs("",s,0);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    public static void dfs(String ip, String left, int cnt){
        if(cnt ==4){
            if(left.equals("")){
                if(!list.contains(ip)){
                    list.add(ip);
                }
            }
            return;
        }else if(cnt < 4 && (left.equals(""))){
            return;
        }
        if(left.charAt(0) == '0'){
            if(cnt ==3){
                dfs(ip+'0',left.substring(1),cnt+1);
            }else{
                dfs(ip+"0.",left.substring(1), cnt+1);
            }
        }else{
            if(cnt==3){
                dfs(ip+left.charAt(0),left.substring(1), cnt+1);
                if(left.length()==2 && Integer.parseInt(left.substring(0,2))<=255){
                    dfs(ip+left.substring(0,2),left.substring(2), cnt+1);
                }
                if(left.length()==3 && Integer.parseInt(left.substring(0,3))<=255){
                    dfs(ip+left.substring(0,3),left.substring(3), cnt+1);
                }
            }else{
                dfs(ip+left.charAt(0)+'.',left.substring(1), cnt+1);
                if(left.length()>=2 && Integer.parseInt(left.substring(0,2))<=255){
                    dfs(ip+left.substring(0,2)+'.',left.substring(2), cnt+1);
                }
                if(left.length()>=3 && Integer.parseInt(left.substring(0,3))<=255){
                    dfs(ip+left.substring(0,3)+'.',left.substring(3), cnt+1);
                }
            }
        }
    }*/
    /*4번 포기
    static List<Integer> list = new ArrayList<>();
    public static int[] solution4(String nums) {
        int[] answer = {};
        dfs();
        return answer;
    }
    public static void dfs(){

    }*/
    static int answer = 0;
    public static int solution(int[] nums) {
        dfs(nums,0, 0);
        return answer;
    }
    public static void dfs(int[] nums, int start, int end){
        int sum =0; int min =Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
            min = Math.min(nums[i], min);
        }
        answer = Math.max(answer, min*sum);
        if(start == nums.length-1){
            return;
        }
        if(end == nums.length-1){
            start +=1;
            end = start;
            dfs(nums, start, end);
        }else{
            end+=1;
            dfs(nums, start, end);
        }
    }

    public static void main(String[] args){
        int[] nums = {2,5,10,9,8,5};
        System.out.println(solution(nums));

    }
}
