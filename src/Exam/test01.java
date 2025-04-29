package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test01 {

    public static void main(String[] args) throws IOException {
        /*운동 중독 플레이어*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int rm = (int) (w *(1+ (float)r/30));

        System.out.println(rm);
    }
}
