package Programmerslv2;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class xy{
    int x; int y;
    public xy(int x, int y){
        this.x = x; this.y = y;
    }
}
public class 카카오프렌즈컬러북 {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visited;
    static int maxnum;
    public static int bfs(int[][] picture, int x, int y,int m, int n ){
        Queue<xy> qu = new LinkedList<>();
        qu.add(new xy(x,y));
        int  cnt = 1;
        int num = picture[x][y];
        while(!qu.isEmpty()){
            xy a = qu.poll();
            for(int[] dir : dirs){
                int nx = a.x + dir[0];
                int ny = a.y + dir[1];
                if(nx>=0&&ny>=0&&nx<m && ny<n){
                    if(picture[nx][ny] == num && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        qu.add(new xy(nx,ny));
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        maxnum = 0;

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(picture[i][j] != 0){
                    maxnum = Math.max(maxnum, picture[i][j]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visited[i][j]){
                    visited[i][j] = true;
                    numberOfArea++;
                    int count = bfs(picture, i, j,m,n);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static void main(String[] args) throws IOException{
        int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
        System.out.println(Arrays.toString(solution(6,4,picture)));
    }
}
