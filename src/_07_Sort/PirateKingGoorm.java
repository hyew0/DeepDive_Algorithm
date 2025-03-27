package _07_Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 입력 예시
5
0 0
0 -2
-1 -1
-5 0
-1 10
-------------------
출력값
0
1
3
4
2
* */
public class PirateKingGoorm {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] xy = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            xy[i][0] =Integer.parseInt(st.nextToken());
            xy[i][1] =Integer.parseInt(st.nextToken());
            xy[i][2] = i;
        }

        Arrays.sort(xy,(x1,x2) -> {
            if (x1[0] == x2[0]) {
                return x1[1] - x2[1]; //x값이 같으므로 y값 비교.
            }else {
                return x1[0] - x2[0]; //x값이 다르므로 x값 비교
            }
        });

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[xy[i][2]] = n - i - 1;
        }


        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }
}
