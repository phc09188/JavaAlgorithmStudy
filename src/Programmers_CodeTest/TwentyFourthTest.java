package Programmers_CodeTest;

import java.util.*;

public class TwentyFourthTest {
    //1
    public int solution1(int[] damages, int shield) {
        int answer = 0;

        for (int i = 0; i < damages.length; i++) {
            if(damages[i] > shield){
                answer += damages[i] - shield;
            }
        }
        return answer+1;
    }
    //2
    public int solution2(String[] words) {
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(i ==j) continue;
                String input = words[i] + words[j];
                boolean isTrue = input.length()%2 != 0;
                if(search2(input,isTrue)) answer++;
            }
        }

        return answer;
    }

    private boolean search2(String input, boolean isTrue) {
        int mid = input.length()/2;
        int i = mid-1;
        int j;
        if(isTrue){
            j = mid + 1;
        }else{
            j = mid;
        }
        while(i>=0 && j <input.length()){
            if(input.charAt(i) != input.charAt(j)){
                return false;
            }
            i--; j++;
        }
        return true;
    }
    //3
    static int[] num;
    public int[] solution3(int[] nums) {
        boolean notGood = true;
        while(notGood) {
            notGood = false;
            num = nums.clone();
            for (int i = 1; i < nums.length-1; i++) {
                if(nums[i]<nums[i-1] && nums[i]<nums[i+1]){
                    num[i]++;
                    notGood = true;
                }
                if(nums[i]>nums[i-1] && nums[i] > nums[i+1]){
                    num[i]--;
                    notGood = true;
                }
            }
            if(notGood) nums = num.clone();

        }
        return num;
    }
    static class Node{
        int x;
        int y;
        int cnt;
        char direction;

        public Node(int x, int y, int cnt, char direction) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.direction = direction;
        }
    }

    public int solution4(int[][] board) {
        int answer = 0;
        int i = 0; int j = 0; char direction = 'E';
        boolean[][] visited = new boolean[board.length][board[0].length];
        while(true){
            if(board[j][i] == 1 || visited[j][i]){
                break;
            }
            visited[j][i] = true;
            if(direction =='E'){
                if(i==board[0].length-1 || board[j][i+1] ==1){
                    j++;
                    direction = 'S';
                }else {
                    i++;
                }
            }else if(direction=='W'){
                if(i==0 || board[j][i-1] ==1){
                    j--;
                    direction = 'N';
                }else {
                    i--;
                }
            }else if(direction=='S'){
                if(j==board.length-1|| board[j+1][i] ==1){
                    i--;
                    direction = 'W';
                }else {
                    j++;
                }
            }else {
                if (j == 0|| board[j-1][i] ==1) {
                    i++;
                    direction = 'E';
                } else {
                    j--;
                }
            }
            answer++;
        }
        return answer;
    }
    //5
    public int[] solution5(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[nums.length/2];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i]; int curDouble = cur*2;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] >curDouble){
                    break;
                }
                if(nums[j] == curDouble){
                    list.add(cur);
                    break;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) !=1 && list.contains(list.get(i)*2)){
                continue;
            }

            answer[cnt++] = list.get(i);
        }
        return answer;
    }

    //6
    public int solution6(int[] x, int[] y) {
        int answer = 0;
        int leftY = 0;
        int rightY = y.length-1;
        for (int i = 0; i < x.length; i++) {
            int curX = x[i];
            boolean isMinus = false;
            if(curX<0) isMinus = true;
            if(isMinus){
                if(y[leftY] >= y[rightY]){
                    answer += curX * y[rightY];
                    rightY -= 1;
                }else{
                    answer += curX * y[leftY];
                    leftY +=1;
                }
            }else{
                if(y[leftY] >= y[rightY]){
                    answer += curX * y[leftY];
                    leftY+=1;
                }else{
                    answer += curX * y[rightY];
                    rightY-=1;
                }
            }
        }

        return answer;
    }
    //7
    public boolean solution7(int[] cards) {
        boolean answer = false;
        int[] clone = cards.clone();
        for (int i = 1; i < cards.length-1; i++) {
            if(cards[i-1] ==1 && cards[i+1] == 1){
                clone[i] = 0;
                answer = true;
            }
        }

        return answer;
    }

    //8
    public int solution(String src, String dst) {
        int answer = 0;
        return answer;
    }


    public static void main(String[] args) {
        TwentyFourthTest a = new TwentyFourthTest();
        int[] damages = {5,3,6,2,4};
        System.out.println(a.solution1(damages,4));
        String[] words = {"zero","base","esab","esabe","orez"};
        System.out.println(a.solution2(words));
        int[] nums = {10,8,6,7,5};
        System.out.println(Arrays.toString(a.solution3(nums)));
        int[][] board = {{0,0,0,0},{0,1,1,0},{0,0,0,0},{1,0,1,1}};
        System.out.println(a.solution4(board));
        int[] nums2 = {1,8,2,4,5,10};
        System.out.println(Arrays.toString(a.solution5(nums2)));
        int[] x = {5,-2,1}; int[] y = {6,1,2,3,4};
        System.out.println(a.solution6(x,y));
    }
}
