package _04_FoundationImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhoIsWinner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] aliceCards = new int[n];
        int[] bobCards = new int[n];

        int aliceCount = 0;
        int bobCount = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aliceCards[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bobCards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (aliceCards[i] == bobCards[i]) {
                aliceCount++;
                bobCount++;
            } else if (Math.abs(aliceCards[i] - bobCards[i]) == 7 ) {
                if (aliceCards[i] < bobCards[i]) {
                    aliceCount += 3;
                    bobCount -=1;
                } else {
                    bobCount += 3;
                    aliceCount -=1;
                }
            } else if (aliceCards[i] > bobCards[i]) {
                aliceCount += 2;
            } else if (aliceCards[i] < bobCards[i]) {
                bobCount += 2;
            }
        }

        System.out.println(aliceCount +" " + bobCount);
    }
}
