package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test04 {
    public static void main(String[] args) throws IOException {
        /*가장 가까운점 찾기*/
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < Q; i++) {
            int p = Integer.parseInt(br.readLine());


            for (int j = 0; j < N; j++) {
                if (arr[j] == p) {
                    System.out.println(arr[j]);
                    break;
                }

                if (p < arr[j]) {
                    if (j == 0) {
                        System.out.println(arr[j]);
                        break;
                    } else {
                        if (Math.abs(arr[j-1] - p) <= Math.abs(arr[j] - p)) {
                            System.out.println(arr[j-1]);
                            break;
                        }
                        System.out.println(arr[j]);
                        break;
                    }
                } else if (j == N - 1) {
                    System.out.println(arr[j]);
                }
            }
        }*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 배열 정렬

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            long p = Long.parseLong(br.readLine());
            int idx = Arrays.binarySearch(arr, (int) p);

            if (idx >= 0) {
                // 정확히 일치하는 값이 있는 경우
                sb.append(arr[idx]).append("\n");
            } else {
                // 이진 탐색 결과가 음수인 경우 삽입 위치 계산
                idx = -(idx + 1);

                // 가장 가까운 값 계산
                if (idx == 0) {
                    sb.append(arr[0]).append("\n");
                } else if (idx == N) {
                    sb.append(arr[N - 1]).append("\n");
                } else {
                    long leftDiff = Math.abs((long) arr[idx - 1] - p);
                    long rightDiff = Math.abs((long) arr[idx] - p);
                    if (leftDiff <= rightDiff) {
                        sb.append(arr[idx - 1]).append("\n");
                    } else {
                        sb.append(arr[idx]).append("\n");
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
