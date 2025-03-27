package _07_Sort;

import java.util.Arrays;
import java.util.Scanner;

/*
8 6
1 2 3 4 5 6 7 8
-----
출력
4
* */
public class SortTask {
    public static void main(String[] args) {
        // Scanner를 사용하여 입력 받기
        Scanner scanner = new Scanner(System.in);

        // N과 K 입력 받기
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // Comparator 사용을 위해 Integer 배열 생성
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        // 배열 정렬:
        // 각 수를 2진수로 변환한 후 1의 개수가 많은 순으로 내림차순 정렬하고,
        // 1의 개수가 같을 경우 원래 숫자 기준으로 내림차순 정렬한다.
        Arrays.sort(arr, (a, b) -> {
            //bitCount는.. 10진수를 2진수로 변경했을 때, 1의 개수를 세는 함수이다.
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            if (countA == countB) {
                return b-a;
            } else {
                return countB - countA;
            }
        });

        // K번째 큰 수 출력 (인덱스는 K-1)
        System.out.println(arr[K - 1]);
    }
}
