package _06_FoundationAlgorithmsChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeComplexity {
    public static void main(String[] args) throws IOException {
        /**
         뒤에 0이 나오려면 10을 곱해야 하고
         10 = 2 * 5  이므로
         2와 5의 개수 중 더 작은 값이 0의 개수가 된다.
         2 보다 5의 빈도가 더 적기 때문에 항상 5의 개수가 2와 같거나 작으므로 5가 몇개 포함되는지 세준다.
         빈도: (2,4,6,8,...) > (5,10,15,...)
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int count = 0;

        while (n > 0) {
            count += n / 5;
            n /= 5;
        }

        System.out.println(count);

    }
}
