package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class test02 {
    public static void main(String[] args) throws IOException {
        /*재고 정리*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken(); // 문자열
            int a = Integer.parseInt(st.nextToken()); // 개수

            // 동일한 문자열이 이미 존재하면 개수를 합침
            map.put(s, map.getOrDefault(s, 0) + a);
        }

        // TreeMap으로 변환하여 사전순 정렬
        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);

        // 결과 출력
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
