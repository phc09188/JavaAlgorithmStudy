package Programmers_CodeTest;

import java.util.LinkedList;
import java.util.Queue;

public class TwentyThreeTest {
    public int solution(int L, int U, int D) {
        int cur = 0;
        int cnt = 0;
        int answer = 0;
        while (cur < L) {
            cur += U;
            cnt++;
            if (cur >= L) {
                answer = cnt;
            } else {
                cur -= D;
            }
        }
        return answer;
    }

    public int solution(String s, int M, int N) {
//        int curM = 0; int curN = 0; int cur = 0;
//        while(true){
//            if(curN<N&& curM<M){
//                curN++;
//                cur++;
//                if(curN >=N){
//
//                }
//            }
//        }

        String[] arr = s.split(" ");
        int cur = 0;
        int cnt = 0;
        int curM = 0;
        while (curM < M) {
            for (int i = 0; i < arr.length; i++) {
                cur += arr[i].length() + 1;
                if (cur-1 == N) {
                    i++;
                    if (i >= arr.length) {
                        break;
                    }
                    cur = arr[i].length() + 1;

                    curM++;
                    if (curM >= M) {
                        if (cur == arr[0].length() + 1) {
                            break;
                        } else {
                            cnt--;
                            break;
                        }

                    }
                } else if (cur-1 > N) {
                    cur = arr[i].length() + 1;
                    curM++;
                    if (curM >= M) {
                        if (cur == arr[0].length() + 1) {
                            break;
                        } else {
                            cnt--;
                            break;
                        }

                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
    //3
    public int solution(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int one = 0; int zero = 0;
            for (int j = i; j < nums.length; j++) {
                if(nums[j] ==0) zero++;
                else one++;
                if(one>zero){
                    cnt++;
                }
            }
        }
        return cnt;
    }


    //4
    static int minX, minY = 1000;
    static int maxX, maxY = 0;
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] image, int x, int y) {
        bfs(image,x,y);
        return (maxY-minY+1) * (maxX-minX+1);
    }
    private void bfs(int[][] image, int x, int y){
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(x,y));
        while(!qu.isEmpty()){
            Node cur =  qu.poll();
            if(visited[cur.x][cur.y]){
                continue;
            }
            visited[cur.x][cur.y] = true;
            minX = Math.min(cur.x, minX);
            minY = Math.min(cur.y, minY);
            maxX = Math.max(cur.x, maxX);
            maxY = Math.max(cur.y, maxY);
            for(int[] dir : dirs){
                int nx = dir[0]+cur.x; int ny = dir[1]+cur.y;
                if(nx >=0 &&nx<image.length&&ny>=0 && ny<image[0].length){
                    if(image[nx][ny] == 1){
                        qu.add(new Node(nx,ny));
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        TwentyThreeTest a = new TwentyThreeTest();
        System.out.println(a.solution(10, 5, 3));
        System.out.println(a.solution("i just called to say i love you by stevie wonder",10,20));
        System.out.println(a.solution("i love zerobase", 5, 9));
        System.out.println(a.solution("i want to study more", 7, 7));
        int[][] image = {{0,0,1,1,1},{0,1,1,1,0},{1,1,1,0,0}};
        System.out.println(a.solution(image,0,2));
        int[] nums = {0,1,0,1,1,0,0,0};
        System.out.println(a.solution(nums));
    }
}
