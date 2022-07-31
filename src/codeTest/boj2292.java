package codeTest;

import java.io.*;
public class boj2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int idx = 1;
        // N이 1이면 기본 값 1로 받는다
        if (N == 1) {
            System.out.println(1);
        } else {
            // 한 칸에 1, 6, 12, 18, 이렇게 6의 배수로 늘어남으로, while문을 돌리며 결과 idx를 뽑아낸다.
            while (N > idx*6) {
                N -= idx * 6;
                idx++;
            }
            //만약 나머지가 존재한다면 한 칸 더 갈 수 있다는 뜻이기 때문에 idx++를 해준다.
            if(N >1) idx++;
            System.out.println(idx);
        }
    }
}
