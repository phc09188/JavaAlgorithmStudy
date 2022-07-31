package codeTest;

import java.io.*;
public class boj15829 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();
        long result = 0;
        for (int i = 0; i < L; i++) {
            result += (input.charAt(i)-96) * Math.pow(31,i);
        }
        System.out.println(result %1234567891);
    }
}
