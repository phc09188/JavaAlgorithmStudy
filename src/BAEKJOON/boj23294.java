package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj23294 {
    static int Max = 2001;
    static int[] cashValue = new int[Max];      // N의 한계치 == 2000
    static int C;           //한도 캐쉬 값
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack1 = new Stack<>();       //현재위치
    static Stack<Integer> stack2= new Stack<>();        //앞 저장소
    static Deque<Integer> stack3= new ArrayDeque<>();       //뒤 저장소
    static int curcash = 0;     //현재 주소 캐쉬 값
    static int frontcash = 0;       //앞 저장소 캐쉬 값
    static int backcash = 0;        // 뒷 저장소 캐쉬 값
    static int cashsum = 0;         //캐쉬 총 합
    static boolean isTrue = true;       //메모리 초과를 해결할 수 없는 상황 예외처리

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //종류 N
        int Q = Integer.parseInt(st.nextToken());   //수행 횟수 Q
        C = Integer.parseInt(st.nextToken());       //한계 C
        st = new StringTokenizer(br.readLine());
        //cash 값을 주소에 맞게 배열로 저장
        for (int i = 1; i <= N; i++) {
            cashValue[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        while(cnt < Q){     //Q번 만큼 작업 실행
            String input = br.readLine();
            web(input);     //작업 함수 web
            cnt++;
        }
        if(isTrue && !stack1.isEmpty()) {   //예외처리가 완성되고, 현재 웹이 켜져있는 경우
            sb.append(stack1.peek() + "\n");
            if (stack3.isEmpty()) {
                sb.append(-1 + "\n");
            } else {
                while (!stack3.isEmpty()) {
                    sb.append(stack3.pollLast() + " ");
                }
                sb.append("\n");
            }
            if (stack2.isEmpty()) {
                sb.append(-1 + "\n");
            } else {
                while (!stack2.isEmpty()) {
                    sb.append(stack2.pop() + " ");
                }
            }
            System.out.println(sb);
        }
    }
    public static void web(String input){
        char[] arr = input.toCharArray();
        int num =0;
        if(arr.length != 1){
            num = arr[2] - 48;
        }
        switch(arr[0]- 'A'){
            case 0:     //num번 페이지에 접속
                stack2.clear();
                frontcash =0;
                if(stack1.isEmpty()){
                    stack1.add(num);
                    curcash += cashValue[num];
                }else {
                    int key = stack1.pop();
                    stack3.add(key);
                    stack1.add(num);
                    curcash += cashValue[num] - cashValue[key];
                    backcash += cashValue[key];
                    cashsum = backcash + curcash + frontcash;
                    while(cashsum > C && !stack3.isEmpty()){
                        int a = stack3.pollFirst();
                        backcash -= cashValue[a];
                        cashsum = backcash + curcash + frontcash;
                    }
                    if(cashsum > C){
                        isTrue = false;
                    }
                }
                break;
            case 1:     //뒤로가기 실행
                if (!stack3.isEmpty()) {
                    int a = stack1.pop();
                    stack2.add(a);
                    int b = stack3.pollLast();
                    stack1.add(b);
                    curcash += cashValue[b] - cashValue[a];
                    frontcash += cashValue[a];
                    backcash -= cashValue[b];
                    cashsum = backcash + curcash + frontcash;
                }
                break;
            case 2:     //압축 실행
                if(!stack3.isEmpty()) {
                    HashSet<Integer> hs = new HashSet<>();
                    int size = stack3.size();
                    for (int i = 0; i < size; i++) {
                        if (!hs.contains(stack3.peekLast())) {
                            hs.add(stack3.peekLast());
                            stack3.addFirst(stack3.pollLast());
                        } else {
                            backcash -= stack3.pollLast();
                        }
                    }
                    cashsum = backcash + curcash + frontcash;
                }
                break;

            case 5:     //앞으로 가기 실행
                if (!stack2.isEmpty()) {
                    int a = stack1.pop();
                    stack3.add(a);
                    int b = stack2.pop();
                    stack1.add(b);
                    curcash += cashValue[b] - cashValue[a];
                    frontcash -= cashValue[b];
                    backcash += cashValue[a];
                    cashsum = backcash + curcash + frontcash;
                }
                break;
        }
    }
}
