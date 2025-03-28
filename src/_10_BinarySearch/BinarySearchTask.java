package _10_BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearchTask {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);
        long M = Long.parseLong(input[1]);

        String result = minWinRate(N,M);
        System.out.println(result);
    }

    private static String minWinRate(long n, long m) {
        int currentRate =(int)((m*100)/n);
        int targetRate = currentRate +1;

        if (currentRate >= 99) return "X"; //99%를 넘으면 아무리 이겨도 이미 진 경기가 있으니까 100%는 만들 수 없음.

        long left = 1, right = 999_999_999_999L, answer= -1;

        while (left <= right) {
            long mid = (left + right)/2;
            int newRate =(int)(((m + mid)*100) / (n + mid)); //mid가 새롭게 이긴 횟수일 때 현재 승률

            if (newRate >= targetRate) {
                answer =mid;
                right = mid - 1; //더 적은 승리로 가능할 수도 있으므로 범위 축소
            } else {
                left = mid + 1; // 목표 승률 미달, 더 많은 승리가 필요
            }
        }

        if (answer == 1_000_000_000_000L) {
            return "X";
        } else {
            return String.valueOf(answer);
        }
    }
}
