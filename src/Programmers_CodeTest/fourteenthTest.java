package Programmers_CodeTest;

import java.util.*;
public class fourteenthTest {
    public static int solution1(int N, int M) {
        int answer = 0;
        double cur = 0;  double a = 0;
        for (int i = 1; i <= N; i++) {
            if(N==i) a = M;
            else {
                a = M / (float) N;
                a *= (float) i;
            }
            int k = (int) Math.floor(cur);
            while(k< a){
                answer++;
                k++;
            }
            cur = a;
        }
        return answer;
    }
    public static String solution(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int index = 0; int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length()-k; i++) {
            min = Integer.MAX_VALUE;
            for (int j = index; j <= k+i; j++) {
                if(min > s.charAt(j) -'0'){
                    min = s.charAt(j) -'0';
                    index = j+1;
                }
            }
            sb.append(min);
        }

        return sb.toString();
    }
    static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int solution(int[][] maze) {
        int answer = 0;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Node> qu = new LinkedList<>();
        visited[0][0] = true;
        qu.add(new Node(0,0,1));
        while(!qu.isEmpty()){
            Node cur = qu.poll();
            visited[cur.x][cur.y] = true;
            boolean nightMode = false;
            if((cur.cnt/5)%2 ==1){
                nightMode = true;
            }
            if(cur.x == maze.length-1 && cur.y == maze[0].length-1){
                answer = cur.cnt;
                break;
            }
            for(int[] dir : dirs){
                int x = cur.x + dir[0]; int y = cur.y + dir[1];

                if(x>=0&& y>=0&&x<maze.length&&y<maze[0].length&& maze[x][y] !=1 && !visited[x][y]){
                    if(nightMode && maze[x][y] ==2){
                        int cnt = cur.cnt;
                        while((cnt/5)%2 ==1){
                            cnt++;
                        }
                        qu.add(new Node(x,y, cnt+2));
                    }else {
                        qu.add(new Node(x, y, cur.cnt + 1));
                    }
                }
            }
        }


        return answer-1;
    }



    public static void main(String[] args){
        System.out.println(solution1(9,1));
        System.out.println(solution("100024",1));
        int[][] maze = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,1,0,2,0,0},{1,1,0,1,0,1},{0,0,0,0,1,0},{1,1,1,0,2,0}};
        System.out.println(solution(maze));
    }
}
