package _05_FoundationSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Woodcutter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M, x 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1; // 0-based index

        int[] H = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }

        int Q = Integer.parseInt(br.readLine());
        String[] commands =br.readLine(). split(" ");

        long count = 0;

        for (int i = 0; i < Q; i++) {
            int currentHeight = H[x] + i;

            if (currentHeight >= M) {
                count += currentHeight;
                H[x] -= currentHeight;
            }

            String direction = commands[i];
            if (direction.equals(("L"))){
                x = (x-1+N) % N;
            } else if (direction.equals("R")) {
                x = (x+1) % N;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}

