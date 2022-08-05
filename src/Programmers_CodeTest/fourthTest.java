package Programmers_CodeTest;

import org.omg.CORBA.INTERNAL;

import java.io.*;
import java.util.*;
class Node {
    HashMap<Character, Node> child;
    // 단어 끝인지 체크 용
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 현재 노드 기준 c 문자에 해당하는 노드가 없으면 추가
            cur.child.putIfAbsent(c, new Node());
            // 이어서 추가하기 위해 다음 문자 쪽으로 이동
            cur = cur.child.get(c);

            // str 끝이면 true 체크 후 return
            if (i == str.length() - 1) {
                cur.isTerminal = true;
                return;
            }
        }
    }

    public boolean search(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 해당 단어 있으면 이동, 없으면 false 반환
            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            } else {
                return false;
            }

            // i 가 str 끝에 도달했지만 cur 의 terminal 이 true 아니면
            // 해당 단어가 들어 있는 것은 아니므로 false 반환
            if (i == str.length() - 1) {
                if (!cur.isTerminal) {
                    return false;
                }
            }
        }
        return true;
    }

    public void delete(String str) {
        boolean ret = this.delete(this.root, str, 0);
        if (ret) {
            System.out.println(str + " 삭제 완료");
        } else {
            System.out.println(str + " 단어가 없습니다.");
        }
    }

    public boolean delete(Node node, String str, int idx) {
        char c = str.charAt(idx);

        // 없는 단어인 경우 false 반환
        if (!node.child.containsKey(c)) {
            return false;
        }

        Node cur = node.child.get(c);
        idx++;

        // 단어의 가장 끝에 도달 후 삭제 결정
        if (idx == str.length()) {
            // 끝에 도달했지만 terminal true 아닌 경우
            // 해당 단어와 일치하는 것은 아니므로 false 반환
            if (!cur.isTerminal) {
                return false;
            }

            // 해당 단어와 일치할 경우 isTerminal false 로 변경
            cur.isTerminal = false;
            // 그 외의 문자 없는 경우 삭제
            if (cur.child.isEmpty()) {
                node.child.remove(c);
            }
        } else {
            if (!this.delete(cur, str, idx)) {
                return false;
            }

            // 끝 문자 삭제 후 앞의 문자들에서 파생되는 단어들 없으면 함께 삭제
            if (!cur.isTerminal && cur.child.isEmpty()) {
                node.child.remove(c);
            }
        }
        return true;
    }
}

public class fourthTest {
    public static int[][] solution5(int[][] buildings) {
        int x = 0; int y =0;
        List<List <Integer>> list = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int left = buildings[i][0];
            int right = buildings[i][1];
            int height = buildings[i][2];
            x = Math.max(right, x);
            y = Math.max(height,y);
        }
        int[][] board = new int[x+1][y+1];
        for (int i = 0; i < buildings.length; i++) {
            int left = buildings[i][0];
            int right = buildings[i][1];
            int height = buildings[i][2];
            for (int j = left; j < right; j++) {
                for (int k = 0; k < height; k++) {
                    board[j][k] = 1;
                }
            }
        }
        int a = 0;
        for (int i = 1; i < board.length; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < board[i].length; j++) {
                if(i==1&& board[i][j] ==0){
                    arr.add(i);
                    arr.add(j);
                    break;
                }
                if(board[i][0] == 0 && board[i-1][0] !=0){
                    arr.add(i);
                    arr.add(0);
                    break;
                }
                if(board[i][j] == 0&& j>=1){
                    if(board[i-1][j-1] != board[i][j-1]|| board[i-1][j] != board[i][j]) {
                        arr.add(i);
                        arr.add(j);
                        break;
                    }
                }
            }
            if(!arr.isEmpty()){
                list.add(arr);
            }
        }
        int[][] answer = new int[list.size()][];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new int[list.get(i).size()];
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                answer[i][j] = list.get(i).get(j);
            }
        }
        return answer;
    }
    public static String[][] solution1(String[] titles, String[] lyrics, String[] problems) {
        List<List <String>> list = new ArrayList<>();
        for (int i = 0; i < problems.length; i++) {
            List<String> arr = new ArrayList<>();
            String input = problems[i];
            int idx = input.length();
            for (int j = 0; j < lyrics.length; j++) {
                String a = lyrics[j].substring(0, idx);
                if(a.equals(input)){
                    arr.add(titles[j]);
                }
            }
            list.add(arr);
        }
        String[][] answer = new String[list.size()][];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String[list.get(i).size()];
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                answer[i][j] = list.get(i).get(j);
            }
        }
        return answer;
    }
//    public static int[] solution4(int[] start, int[] time) {
//        int[] answer = new int[start.length];
//        boolean[] visited = new boolean[start.length];
//        int i =0; int t =0; int cnt = 0;
//        int min = Integer.MAX_VALUE;
//        int minvalue = Integer.MAX_VALUE;
//        HashMap<Integer,Integer> hm = new HashMap<>();
//        PriorityQueue<Node> pq = new PriorityQueue<>((Node o1, Node o2) -> o1.time<o2.time ? -1:1);
//        for (int j = 0; j < start.length; j++) {
//            min = Math.min(min, start[j]);
//            minvalue = Math.min(minvalue, time[j]);
//            hm.put(start[j], j);
//        }
//        for (int j = 0; j < start.length; j++) {
//            if(min == start[j] &&minvalue == time[j]){
//                i = j;
//                break;
//            }
//        }
//        visited[i] = true;
//        pq.add(new Node(start[i], time[i]));
//        while(!pq.isEmpty()){
//            Node a = pq.poll();
//            i = a.start;
//            t += a.time;
//            answer[cnt] = hm.get(a.start);
//            for (int j = 0; j < start.length; j++) {
//                if(start[j] <=t && !visited[j]){
//                    visited[j] = true;
//                    pq.add(new Node(start[j], time[j]));
//                }
//            }
//            cnt++;
//        }
//        return answer;
//    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] titles = {"아모르파티","아기상어","올챙이와개구리", "산다는건"};
        String[] lyrics = {"산다는게다그런거지누구나빈손으로와","아기상어뚜루루뚜루여운뚜루루뚜루","개울가에올챙이한마리꼬물꼬헤엄치다","산다는건다그런거래힘들고아픈날도많지만"};
        String[] problems = {"산다", "아기상어", "올챙이"};
        System.out.println(Arrays.deepToString(solution1(titles,lyrics,problems)));
        String[] words = {"hello", "hell", "good", "goose", "children", "card", "teachable"};
        String[] quaries = {"hell*", "goo*", "*able", "qua*"};
        //System.out.println(Arrays.toString(solution2(words,quaries)));
        int[] start = {0, 2, 3, 5, 6};
        int[] time = {2, 4, 2, 1, 3};
        //System.out.println(Arrays.toString(solution4(start,time)));
        int[][] buildings = {{1, 8, 4}, {2, 4, 10}, {3, 5, 6}, {10, 12, 6}};
        System.out.println(Arrays.deepToString(solution5(buildings)));
    }
}
