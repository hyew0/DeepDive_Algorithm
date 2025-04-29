package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test03 {
    /*연합 문제 - 미해결*/


    /*public static void main(String[] args) throws IOException {
        *//*연합*//*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end); // 단방향 그래프
        }

        boolean[] visited = new boolean[N + 1];
        int unionCount = 0;

        // BFS를 사용하여 연합 탐색
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i, graph, visited);
                unionCount++;
            }
        }

        System.out.println("연합의 개수: " + unionCount);
    }

    private static void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }*/

    static List<List<Integer>> graph = new ArrayList<>();
    static List<List<Integer>> reversedGraph = new ArrayList<>();
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }

        // 그래프 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);            // 원래 그래프
            reversedGraph.get(to).add(from);    // 역방향 그래프
        }

        visited = new boolean[N + 1];

        // 1단계: 원래 그래프에서 DFS
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        // 2단계: 역방향 그래프에서 DFS
        Arrays.fill(visited, false); // 방문 배열 초기화
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                reverseDfs(node);
                sccCount++;
            }
        }

        System.out.println(sccCount);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }

        stack.push(node); // 탐색 완료된 노드를 스택에 저장
    }

    private static void reverseDfs(int node) {
        visited[node] = true;

        for (int next : reversedGraph.get(node)) {
            if (!visited[next]) {
                reverseDfs(next);
            }
        }
    }

}
