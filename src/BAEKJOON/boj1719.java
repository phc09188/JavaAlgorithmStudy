package BAEKJOON;

import java.io.*;
import java.util.*;

// 플로이드 와샬
public class boj1719 {

    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 집하장간 경로의 개수
        int[][] matrix = new int[n+1][n+1];
        int[][] path = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            Arrays.fill(matrix[i], 10001);
            matrix[i][i]=0;
        }

        // 2. 구현
        // 2-1. 인접 행렬
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            matrix[to][from] = val;
            matrix[from][to] = val;

            path[from][to] = from;
            path[to][from] = to;
        }

        // 2-2. 플로이드 와샬
        for (int k = 1; k < n+1; k++) {         // 경로
            for (int i = 1; i < n+1; i++) {     // 출발
                for (int j = 1; j < n+1; j++) { // 도착
                    if(matrix[i][j]>matrix[i][k]+matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j]; // 최단 경로 갱신
                        path[i][j] = path[k][j]; // i에서 j까지 => k를 지나 j까지
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(i==j) sb.append("- ");
                else sb.append(path[j][i]+" ");
            }sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}