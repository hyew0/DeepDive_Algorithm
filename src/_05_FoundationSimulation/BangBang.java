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
        long BangCount =0; // 총 발사 횟수
        int count = 0;


        for (int i = 0; i < n; i++) {
            int strength = Integer.parseInt(st.nextToken());

            //권총이 주는 피해가 1이 될때까지, 체력이 남지 않을 때까지 반복
            while (count > 0 && strength > 0) {
                strength -= count + 1;
                count = (count + 1) % 4;
                BangCount++;
            }


            if (strength <= 0) {
                continue;
            }

            //값이 10이 넘어갈경우 (1+2+3+4) = 10이므로 체력 10당 총을 4번 발사한 것임. 그래서 10으로 나눈 값에 4를 곱해주면 해당 횟수만큼 총을 쏜것.
            BangCount += (strength / 10) *4;
            strength %= 10;

            //10미만의 체력이 남았다면 해당 횟수를 계산
            while (strength > 0) {
                strength -= count + 1;
                count = (count + 1) % 4;
                BangCount++;
            }
        }

        System.out.println(BangCount);
    }
}
