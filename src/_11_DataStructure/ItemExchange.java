package _11_DataStructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ItemExchange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> goormItems = new HashSet<>();
        HashSet<String> friendItems = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            goormItems.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            friendItems.add(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            if (goormItems.contains(a) && friendItems.contains(b)) {
                goormItems.remove(a);
                friendItems.remove(b);
                goormItems.add(b);
                friendItems.add(a);
            }
        }

        LinkedList<String> listGoormItems = new LinkedList<>(goormItems);

        Collections.sort(listGoormItems);
        for (int i = 0; i < listGoormItems.size(); i++) {
            System.out.print(listGoormItems.get(i) + " ");
        }
    }
}
