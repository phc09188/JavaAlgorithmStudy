package Programmerslv2;

import java.util.*;
class Person{
    int x;
    int y;
    int cnt;
    public Person(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class 거리두기확인하기 {
    static int[][] dirs = {{-1,0}, {1,0}, {0,1},{0,-1}};
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int N = 0;
        while(N<places.length){
            Queue<Person> qu = new LinkedList<>();
            boolean[][] visited = new boolean[places[N].length][places[N][0].length()];
            int[][] arr = new int[places[N].length][places[N][0].length()];
            for (int i = 0; i < places[N].length; i++) {
                for (int j = 0; j < places[N][i].length(); j++) {
                    if(places[N][i].charAt(j) == 'P'){
                        arr[i][j] = 1;
                        visited[i][j] = true;
                        qu.add(new Person(i,j,0));
                    }
                    if(places[N][i].charAt(j) == 'X') arr[i][j] = 0;
                    if(places[N][i].charAt(j) == 'O') arr[i][j] = 2;
                }
            }
            boolean istrue = true;
            while(istrue && !qu.isEmpty()){
                Person p = qu.poll();
                int x = p.x; int y = p.y; int cnt = p.cnt;
                for(int[] dir : dirs){
                    int x2 = p.x +dir[0]; int y2 = p.y + dir[1];
                    if(x2>=0 && x2< places[N].length&& y2 >=0 && y2<places[N][0].length() &&!visited[x2][y2]){
                        if(arr[x2][y2] == 2){
                            qu.add(new Person(x2, y2, cnt+1));
                            visited[x2][y2] = true;
                        }else if(arr[x2][y2] == 1 && cnt+1 <=2){
                            istrue = false;
                            break;
                        }
                    }
                    if(!istrue) break;
                }
            }
            if(istrue){
                answer[N] = 1;
            }else answer[N] = 0;
            N++;
        }

        return answer;
    }
    public static void main(String[] args){
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(places)));
    }
}
