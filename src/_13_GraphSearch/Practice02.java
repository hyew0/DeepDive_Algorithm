package _13_GraphSearch;

import java.util.*;

public class Practice02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수

        List<List<Integer>> G = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            G.get(s).add(e);
        }

        boolean[] V = new boolean[N + 1];
        Stack<Integer> s = new Stack<>();
        s.add(1);
        V[1] = true;

        while (!s.isEmpty()) {
            int current_Node = s.pop();
            System.out.println(current_Node);

            for (int next_Node : G.get(current_Node)) {
                if (!V[next_Node]) {
                    s.add(next_Node);
                    V[next_Node] = true;
                }
            }
        }
    }
}
