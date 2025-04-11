package _05_FoundationSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BangBang {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int BangCount =0;

        for (int i = 1; i <= n; i++) {
            int strength = Integer.parseInt(st.nextToken());

            while (strength > 0) {
                BangCount++;
                strength -=((BangCount - 1) % 4) + 1;
            }
        }

        System.out.println(BangCount);
    }
}
