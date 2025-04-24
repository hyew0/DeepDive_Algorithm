package _06_FoundationAlgorithmsChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoormRPG1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int armor = Integer.parseInt(br.readLine());

            if (armor == 2) { //갑옷 고유값이 2이면 무기 고유값보다 값이 클 수 없으므로 바로 값 넣어줌
                sb.append("Yes\n");
                continue;
            }

            boolean found = false;

            // 2부터 sqrt(armor)까지 반복 (약수 탐색은 sqrt까지 보면 충분함) - 가장 작은 소수나 가장 작은 약수를 구하면 됨
            for (int w = 2; w * w <= armor; w++) {
                if (armor % w == 0 && armor > w) {
                    sb.append("No\n");
                    found = true;
                    break;
                }
            }

            if (!found) {
                sb.append("Yes\n");
            }
        }
        System.out.println(sb);
    }
}
