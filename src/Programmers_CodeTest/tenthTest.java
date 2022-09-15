package Programmers_CodeTest;

import java.util.*;
public class tenthTest {
    public static String[] solution1(int n) {
        String[][] board = {
                {"#####", "#---#","#---#","#---#","#####"} //0
                ,{"--#--","--#--","--#--","--#--","--#--"} //1
                ,{"#####","----#","#####","#----","#####"} //2
                ,{"#####","----#","#####","----#","#####"} //3
                ,{"#---#","#---#","#####","----#","----#"} //4
                ,{"#####","#----","#####","----#","#####"} //5
                ,{"#####","#----","#####","#---#","#####"} //6
                ,{"#####","----#","----#","----#","----#"} //7
                ,{"#####","#---#","#####","#---#","#####"} //8
                ,{"#####","#---#","#####","----#","----#"} //9
        };
        Stack<Integer> stack = new Stack<>();
        while(n >0){
            int temp = n%10;
            stack.add(temp);
            n = n/10;
        }
        String[] answer = {"","","","",""};
        while(!stack.isEmpty()){
            int k = stack.pop();
            if(stack.isEmpty()){
                for (int i = 0; i < 5; i++) {
                    answer[i] += board[k][i];
                }
            }else {
                for (int i = 0; i < 5; i++) {
                    answer[i] += board[k][i] +" ";
                }
            }
        }
        return answer;
    }
    static class Trade {
        int num;
        int cnt;

        public Trade(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    public static int solution(int num) {
        int n = num;
        int k = 1;
        int result = -1;
        Queue<Trade> qu = new LinkedList<>();
        boolean[] visited = new boolean[1000001];
        qu.add(new Trade(n,0));
        visited[n] = true;
        while(!qu.isEmpty()){
            Trade t = qu.poll();
            if(t.cnt ==1){
                result = Math.max(result, t.num);
                continue;
            }
            int len = String.valueOf(t.num).length();
            for (int i = 0; i < len - 1; i++) {
                for (int j = i+1; j < len; j++) {
                    int nextnum = swap(t.num, i,j);
                    if(nextnum !=-1 &&!visited[nextnum]){
                        qu.add(new Trade(nextnum, t.cnt+1));
                        visited[nextnum] = true;
                    }
                }
            }
        }
        return result;
    }
    public static int swap(int n, int i, int j) {
        char[] numArr = String.valueOf(n).toCharArray();

        if (i == 0 && numArr[j] == '0') {
            return -1;
        }

        char tmp;
        tmp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = tmp;

        return Integer.parseInt(new String(numArr));
    }

    public static boolean solution4(int[] param0) {
        boolean answer = false;
        PriorityQueue<Integer> qu = new PriorityQueue<>((x,y) -> y-x);
        qu.add(0);
        while(!qu.isEmpty()){
            int cur = qu.poll();
            if(cur == param0.length){
                answer = true;
                break;
            }
            if(param0[cur] == 0){
                continue;
            }
            for (int i = 1; i <= param0[cur]; i++) {
                if(cur+i >param0.length){
                    continue;
                }
                qu.add(cur+i);
            }
        }
        return answer;
    }
    /*static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int[] distance;
    public static int solution5(int N, int[][] edge) {
        boolean[] visited = new boolean[N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        pq.add(new Node(0, 0));
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Node>arr = new ArrayList<>();
            list.add(arr);
        }
        for (int i = 0; i < edge.length; i++) {
            int start = edge[i][0]; int end = edge[i][1]; int weight = edge[i][2];
            list.get(start).add(new Node(end, weight));
        }
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            if (visited[currentNode.to]) continue;
            visited[currentNode.to] = true;
            for (Node node : list.get(currentNode.to)) {
                if (distance[node.to] > distance[currentNode.to] + node.weight) {
                    distance[node.to] = distance[currentNode.to] + node.weight;
                    pq.add(new Node(node.to, distance[node.to]));
                }
            }
        }
        int answer = 0; int answeridx =-1;
        for (int i = 1; i < N; i++) {
            if(answer <distance[i]){
                answer = distance[i];
                answeridx = i;
            }
        }
        return answeridx;
    }*/
    static class Node
    {
        int key;
        Node left = null, right = null;

        Node(int key) {
            this.key = key;
        }
    }
    public static int[] solution(int N, int[][] left, int[][] right) {
        Node root = new Node(0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < left.length; j++) {
                if(left[j][0] >i) break;
                if(left[j][0] == i){
                    Node cur = search(left[j][0], root);
                    cur.left = new Node(left[j][1]);
                    break;
                }
            }
            for (int j = 0; j < right.length; j++) {
                if(right[j][0]>i) break;
                if(right[j][0] == i){
                    Node cur = search(left[j][0], root);
                    cur.right = new Node(right[j][1]);
                    break;
                }
            }

        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, 0, root);
        int[] answer = {};
        return answer;
    }
    public static Node search(Integer data, Node root) {


        Node cursor = root;

        while(true) {
            if(cursor == null) {
                return null;
            }

            if(cursor.key == data) {
                return cursor;
            } else {
                if(data > cursor.key) {
                    cursor = cursor.left;
                } else {
                    cursor = cursor.right;
                }
            }
        }
    }
    public static void dfs(List<List<Integer>> result, int level, Node node) {
        if(node == null){return;}
        if(result.size() <= level){  // 현재 level List가 없을 경우  ex)size가 1이면 0뎁스까지밖에 없음. 1뎁스일때 만들어줘야함.
            List<Integer> row = new ArrayList<>();
            row.add(node.key);
            result.add(row);
        }else{
            List<Integer> row = result.get(level);
            row.add(node.key);
        }
        dfs(result, level+1,node.left);
        dfs(result, level+1,node.right);
    }
    public static void main(String[] args){
//        System.out.println(Arrays.deepToString(solution1(132)));
//        System.out.println(solution(43824));
//        int[] num = {3,4,1,1,0,3};
//        System.out.println(solution4(num));
//        int[][] edge = {{0,1,5},{0,2,7},{1,3,10},{3,4,8},{2,4,9},{4,2,1}};
//        System.out.println(solution(5,edge));
        int[][] left = {{0,1}, {1,5},{2,3}};
        int[][] right = {{0,2},{3,4}};
        System.out.println(Arrays.toString(solution(6,left,right)));
    }
}
