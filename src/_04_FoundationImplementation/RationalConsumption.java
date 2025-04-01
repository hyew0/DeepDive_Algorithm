package _04_FoundationImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RationalConsumption {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int min = 0, max = 100001;
        String minName="", maxName = "";

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            if(i == 0){
                min = price;
                minName = name;
                max = price;
                maxName = name;
            }

            if (price < min) {
                min = price;
                minName = name;
            } else if (price > max) {
                max = price;
                maxName = name;
            }

        }

        System.out.println(maxName + " " + max);
        System.out.println(minName + " " + min);

    }
}
