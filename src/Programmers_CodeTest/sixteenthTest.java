package Programmers_CodeTest;

import java.util.*;
public class sixteenthTest {
    public int[] solution(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        int[] answer = new int[k];
        List<Map.Entry<Integer,Integer>> list_entries = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int cnt = 0;
        for(Map.Entry<Integer,Integer> entry : list_entries){
            if(cnt <k) {
                answer[cnt++] = entry.getKey();
            }else{
                break;
            }
        }
        return answer;
    }
    static int answer3 = Integer.MAX_VALUE;
    void combination(int[] nums, boolean[] visited, int depth, int k, int r){
        if(r == 0){
            int start = 0; int end =0; boolean turn = false; int cnt = 0; int size = k/3;
            for (int i = 0; i < nums.length; i++) {
                if(!visited[i]){
                    if(!turn){
                        start += nums[i];
                        cnt++;
                        if(cnt ==size){
                            turn = true;
                        }
                    }else {
                        end += nums[i];
                    }
                }
            }
            answer3 = Math.min(answer3, (start -end));
        }
        if(depth ==k){
            return;
        }
        visited[depth] = true;
        combination(nums, visited, depth+1, k, r-1);
        visited[depth] = false;
        combination(nums, visited, depth+1, k, r);
    }
    public int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        combination(nums,visited,0,nums.length,nums.length/3);
        return answer3;
    }

    public int solution3(int[] nums) {
        int max = 0;  int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i]; int firstLength = 0;
            while(cur>0){
                firstLength += cur %10;
                cur /=10;
            }
            for (int j = i+1; j < nums.length; j++) {
                int length = 0;
                cur = nums[j];
                while(cur>0){
                    length += cur %10;
                    cur /=10;
                }
                if(length == firstLength){
                    answer = Math.max(answer,(nums[i] + nums[j]));
                }
            }
        }
        return answer;
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
    public int solution(int[][] heights) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int answer = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(0,0,0));
        while(!qu.isEmpty()){
            Node cur = qu.poll();
            visited[cur.x][cur.y] = true;
            if(cur.x == heights.length-1 && cur.y == heights[0].length-1){
                answer = Math.min(answer, cur.cnt);
            }
            for(int[] dir : dirs){
                int nx = cur.x+dir[0]; int ny = cur.y+dir[1];
                if(nx>=0 && nx<heights.length && ny>=0 && ny<heights[0].length){
                    if(!visited[nx][ny]){
                        int c = Math.abs(heights[cur.x][cur.y] - heights[nx][ny]);
                        if(cur.cnt<c){
                            cur.cnt = c;
                        }
                        qu.add(new Node(nx,ny, cur.cnt));
                    }
                }
            }

        }
        return answer;
    }
    public int solution5(int[][] heights) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int col = heights.length; int row = heights[0].length; int k = 0;
        while(row -1 -k >=0) {
            for (int i = k; i < col-k; i++) {
                if (heights[i][k] < heights[i][row - 1-k]) {
                    min = Math.min(min, heights[i][k]);
                } else {
                    min = Math.min(min, heights[i][row - 1-k]);
                }
            }
            for (int i = k; i < row-k; i++) {
                if (heights[k][i] < heights[col - 1-k][i]) {
                    min = Math.min(min, heights[k][i]);
                } else {
                    min = Math.min(min, heights[col - 1-k][i]);
                }
            }
            for (int i = 1+k; i < col - 1-k; i++) {
                for (int j = 1+k; j < row - 1-k; j++) {
                    answer += Math.abs(min - heights[i][j]);
                }
            }
            k++;
        }
        return answer;
    }

    public static void main(String[] args){
        sixteenthTest a = new sixteenthTest();
        int[] nums = {1,1,1,1,2,2,2,3,3,3,4,4,4,4};
        int[] nums3 = {18,36,72,16,52};
        int[] nums2 = {7,9,1,5,8,3};
        System.out.println(a.solution(nums2));
        System.out.println(Arrays.toString(a.solution(nums,3)));
        System.out.println(a.solution3(nums3));
        int[][] height = {{1,2,2}, {3,10,2},{5,3,5}};
        System.out.println(a.solution(height));
        int[][] heights = {{3,4,5,4,3,3},{3,2,1,1,2,3},{4,2,1,1,2,3},{3,3,3,3,5,3}};
        System.out.println(a.solution5(heights));
    }
}
