package _06_FoundationAlgorithmsChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameJam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[][] goormBoard = new boolean[n][n];
        boolean[][] playerBoard = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] goormXY = {Integer.parseInt(st.nextToken()) -1 ,Integer.parseInt(st.nextToken()) - 1};

        st = new StringTokenizer(br.readLine());
        int[] playerXY = {Integer.parseInt(st.nextToken()) -1 ,Integer.parseInt(st.nextToken()) - 1};

        String[][] directions = new String[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                directions[i][j] = st.nextToken(); // "1L" 같은 형식
            }
        }

        int goormCount = move(goormXY,goormBoard,directions,n);
        int playerCount = move(playerXY,playerBoard,directions,n);




        // 결과 출력
        if (goormCount >= playerCount) {
            System.out.println("goorm " + goormCount);
        } else {
            System.out.println("player "+playerCount);
        }
    }

    private static int[] getDirection(String dir) {
        return switch (dir) {
            case "L" -> new int[]{0, -1};
            case "R" -> new int[]{0, 1};
            case "U" -> new int[]{-1, 0};
            case "D" -> new int[]{1, 0};
            default -> throw new IllegalArgumentException("Invalid direction");
        };
    }

    public static int set_Pos(int a, int N) {
        if (a == -1) return N - 1;
        if (a == N) return 0;
        return a;
    }




    private static int move(int[] pos, boolean[][] checkBoard, String[][] directions, int n) {
        int x = pos[0];
        int y = pos[1];
        int count = 1;

        checkBoard[x][y] = true;
        boolean flag = true;

        while (flag){
            String command = directions[x][y];
            int distance = Integer.parseInt(command.substring(0, command.length() - 1)); //갈 거리
            String direction = command.substring(command.length() -1); //방향

            for (int i = 0; i < distance; i++) {
                x += getDirection(direction)[0];
                y += getDirection(direction)[1];
                x = set_Pos(x, n);
                y = set_Pos(y, n);

                if (!checkBoard[x][y]) {
                    checkBoard[x][y] = true;
                    count++;
                } else {
                    flag = false;
                    break;
                }
            }
        }

        return count;

    }


}

