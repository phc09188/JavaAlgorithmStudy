package Programmers_CodeTest;


import java.util.*;

public class TwentyOneThTest {
    /** 1 **/
    public static String[] solution(String[] phrases) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < phrases.length-1; i++) {
            String[] arr1 = phrases[i].split(" ");
            for (int j = i+1; j < phrases.length; j++) {
                String[] arr2 = phrases[j].split(" ");
                if(arr1[0].equals(arr2[arr2.length - 1])){
                    String input = phrases[j].substring(0,phrases[j].length()- arr2[arr2.length-1].length()) + phrases[i];
                    list.add(input);
                }
                if(arr1[arr1.length-1].equals(arr2[0])){
                    String input = phrases[i].substring(0,phrases[i].length()- arr1[arr1.length-1].length()) + phrases[j];
                    list.add(input);
                }
            }
            if(arr1.length ==1){
                list.add(arr1[0]);
            }
        }
        Collections.sort(list);
        String[] answer = list.toArray(new String[0]);
        return answer;
    }
    /** 2 **/
    public static boolean solution(String s, String t) {
        if(s.length() == t.length()){
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != t.charAt(i)){
                    cnt++;
                }
                if(cnt >1){
                    return false;
                }
            }
            return true;
        }
        if(Math.abs(s.length() - t.length()) !=1){
            return false;
        }
        int i = 0; int j = 0;
        while(true){
            if(i >= s.length() || j >= t.length()){
                return true;
            }
            if(s.charAt(i) != t.charAt(j)){
                if(s.length() >i+1 && s.charAt(i+1) == t.charAt(j)){
                    i++;
                }else if(t.length()>j+1 && t.charAt(j+1) == s.charAt(i)){
                    j++;
                }else{
                    return false;
                }
            }else{
                i++; j++;
            }

        }
    }
    /** 3 **/
    public static int solution(int[][] trans) {
        int answer = 0;
        boolean[] visited = new boolean[trans.length];
        for (int i = 0; i < 10; i++) {
            int a = 0; int b =0;
            for (int j = 0; j < trans.length; j++) {
                if(!visited[j]&&trans[j][0] == i){
                    a++;
                    visited[j] = true;
                }else if(!visited[j]&&trans[j][1] == i){
                    b++;
                    visited[j] = true;
                }
            }
            if(Math.abs(a-b) !=0){
                if(a> b){
                    answer +=a;
                }else{
                    answer +=b;
                }
            }
        }
        return answer;
    }
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt;
    public static int[][] solution4(int[][] board) {
        map = board;
        while(true){
            visited = new boolean[board.length][board[0].length];
            boolean flag = false;
            for (int i = board.length-1; i >=0; i--) {
                for (int j = board[0].length-1; j >=0 ; j--) {
                    if(!visited[i][j] && map[i][j] != 0){
                        cnt = 1;
                        if(findCnt(i,j,map[i][j])){
                            flag = true;
                            bfs(i,j,map[i][j]);
                        }
                    }
                }
            }
            if(flag) {
                while (true) {
                    boolean check = false;
                    check = clean(check);
                    if (!check) {
                        break;
                    }
                }
            }else{
                break;
            }
        }
        return map;
    }

    private static boolean clean(boolean check) {
        for (int i=0; i<map.length-1; i++) {
            for (int j = 0; j<map[0].length; j++) {
                if (map[i][j] != 0 && map[i][j] != -1 && map[i+1][j] == -1) {
                    check = true;
                    int temp = map[i][j];
                    map[i][j] = 0;
                    map[i+1][j] = temp;
                }else if(map[i][j] ==0 && map[i+1][j] ==-1){
                    for (int k = i+1; k < map.length; k++) {
                        map[k][j] = 0;
                    }
                }
            }
        }
        return check;
    }

    private static void bfs(int x, int y, int num) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(x,y));
        while(!qu.isEmpty()){
            Node cur = qu.poll();
            int qx = cur.x;
            int qy = cur.y;
            for (int i = 0; i < dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];
                if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length || map[nx][ny] == 0){
                    continue;
                }
                if(visited[nx][ny] && map[nx][ny] == num){
                    map[nx][ny] = -1;
                    qu.add(new Node(nx,ny));
                }
            }
        }
    }

    private static boolean findCnt(int x, int y, int num) {
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length || map[nx][ny] == 0){
                continue;
            }
            if(!visited[nx][ny] && map[nx][ny] ==num){
                cnt++;
                findCnt(nx,ny,num);
            }
        }
        if(cnt >=4) return true;
        else return false;
    }
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        String[] phrases = {"happy", "yourself is good", "happy with zerobase", "be nice to yourself", "do not be"};
        System.out.println(Arrays.toString(solution(phrases)));
        System.out.println(solution("zEroBase","zeroBase"));
        int[][] trans = {{0,3,2000},{1,0,2200},{0,2,200}};
        int[][] map = {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},
                {0,0,0,0,0,0},{0,0,1,2,3,0},{0,1,2,3,4,4},{1,2,3,4,4,4}};
        System.out.println(solution(trans));
        System.out.println(solution4(map));
    }
}
