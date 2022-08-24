package Programmerslv2;

import java.io.*;
import java.util.*;
public class 쿼드압축후개수세기 {
    static int[] answer = new int[2];
    public static int[] solution(int[][] arr) {
        int totalsize = arr.length;
        dps(0,0,totalsize, arr);
        return answer;
    }
    public static void dps(int startX, int startY, int size, int[][] arr){
        if(check(startX,startY, size, arr)){
            answer[arr[startX][startY]]++;
            return;
        }
        dps(startX,startY,size/2, arr);
        dps(startX+ size/2, startY, size/2, arr);
        dps(startX, startY + size/2, size/2, arr);
        dps(startX+size/2, startY+size/2, size/2, arr);
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
    }
    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
