package _10_BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

/*
7 5
5 1 9 3 7 2 6
1 4
0 0
5 10
3 3
8 9
------------
3
0
4
1
1
* */
public class AboveAndBelow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            int L = sc.nextInt();
            int R = sc.nextInt();

            int lowIdx = lowerBound(arr, L);
            int highIdx = upperBound(arr, R);

            int answer = highIdx - lowIdx;
            System.out.println(answer);
        }
        sc.close();
    }

    public static int lowerBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
