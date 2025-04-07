package _13_GraphSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] matrix = new int[N][N];
        int[][] V = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                matrix[i][j] = sc.nextInt();

        //하상우좌 순서
        int[] dx = {0, 0, 1, -1}; 
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        V[0][0] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];

            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if (0 <= next_x && next_x < N && 0 <= next_y && next_y < N) {
                    if (matrix[next_y][next_x] == 0 &  V[next_y][next_x] == 0) {
                        q.add(new int[]{next_y, next_x});
                        V[next_y][next_x] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }
    }
}
