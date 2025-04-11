package _05_FoundationSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CloneRobot {
    public static void main(String[] args) throws IOException {
        /*
        복제로봇
        1. 로봇은 상하좌우로 움직인다.
        2. 들판에는 웅덩이가 존재하고 그 웅덩이가 있는 좌표로 움직이라는 명령이 있으면 무시한다.
        3. 로봇의 최종 위치를 출력한다.
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        int[][] puddle = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            puddle[i][0] = Integer.parseInt(st.nextToken());
            puddle[i][1] = Integer.parseInt(st.nextToken());
        }

        int Q = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            String direction = st.nextToken();

            int nextX = x, nextY = y;

            if (direction.equals("L")) nextX--;
            else if(direction.equals("R")) nextX++;
            else if(direction.equals("U")) nextY++;
            else if(direction.equals("D")) nextY--;

            boolean isPuddle = false;
            for (int j = 0; j < n; j++) {
                if (puddle[j][0] == nextX && puddle[j][1] == nextY) {
                    isPuddle = true;
                    break;
                }
            }

            if (!isPuddle) {
                x = nextX;
                y = nextY;
            }
        }

        System.out.println(x + " " + y);

    }
}
