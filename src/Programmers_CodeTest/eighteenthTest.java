package Programmers_CodeTest;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class eighteenthTest {

    public int solution(int[] food) {
        int total = 0;
        for (int i = 0; i < food.length; i++) {
            total += food[i];
        }
        return total%2 == 0 ? total/2 : (total/2)+1;
    }
    //7907
    public int solution(int n) {
        List<Integer> primes = primeList();
        boolean[] isFalse = new boolean[7908];
        int cnt = 1;
        for (int i = 3; i < primes.size(); i++) {
            cnt = 1; int input = primes.get(i);
            while(input*cnt < 7908){
                isFalse[input * cnt++] = true;
            }
        }
        cnt = 0;
        for (int i = 1; i < isFalse.length; i++) {
            if(!isFalse[i]){
                cnt++;
                if(cnt == n){
                    return i;
                }
            }
        }
        return -1;
    }
    public List<Integer> primeList(){
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 7907; i++) {
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }
    public boolean isPrime(int number){
        if(number==2){
            return true;
        }
        for (int i =2; i < number; i++) {
            if(number%i ==0){
                return false;
            }
        }
        return true;
    }

    public String solution(int[][] points) {
        int value = (points[0][0] * points[1][1] + points[1][0]*points[2][1] + points[2][0]*points[0][1])
                - (points[0][1]*points[1][0] + points[1][1]*points[2][0]+points[2][1]*points[0][1]);
        if(value==0) return "LINE";
        else if(value>0) return "CCW";
        else return "CW";
    }
    public int solution(int[] x, int[] y, int k) {
        int answer= 0;
        for (int i = 0; i < x.length-1; i++) {
            for (int j = i+1; j < x.length; j++) {
                if(k>= Math.abs(x[i] -x[j])){
                    int a = y[i] + y[j] + Math.abs(x[i] - x[j]);
                    answer = Math.max(answer, a);
                }
            }
        }
        return answer;
    }
    public int solution(int N, int[][] stones) {
        HashSet xSet = new HashSet();
        HashSet ySet = new HashSet();
        for(int[] stone : stones){
            if(!xSet.contains(stone[0])) xSet.add(stone[0]);
        }
        for(int[] stone : stones){
            if(!xSet.contains(stone[0])){
                if(!ySet.contains(stone[1])) ySet.add(stone[1]);
            }
        }
        return (xSet.size()) + (ySet.size());
    }


    public static void main(String[] args) {
        int[] foods = {6,3,4,5};
        eighteenthTest a = new eighteenthTest();
        System.out.println(a.solution(foods));

        System.out.println(a.solution(1000));

        int[][] points = {{4,7},{-3,5},{2,4}};
        System.out.println(a.solution(points));

        int[] x = {1,2,5,6}; int[] y = {3,1,10,-9};
        System.out.println(a.solution(x,y,2));
        int[][] stones = {{0,0}, {0,2}, {2,0},{2,2}};
        System.out.println(a.solution(6,stones));

    }

}
