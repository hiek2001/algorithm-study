package Beakjoon.gold;
import java.util.*;
import java.io.*;
// 문제 풀이 : https://ranny-devlog.tistory.com/entry/%EB%B0%B1%EC%A4%80-5972-%ED%83%9D%EB%B0%B0-%EB%B0%B0%EC%86%A1-JAVA-%ED%92%80%EC%9D%B4
public class bj5972 {
    static ArrayList<Node> arr[];
    static boolean[] visited;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int targetNode, weight;

        Node(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.weight, n.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[u].add(new Node(v, w));
            arr[v].add(new Node(u, w));
        }

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);

        System.out.println(solution(1, N));
    }

    static int solution(int start, int end) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        dist[start] = 0;

        while (!que.isEmpty()) {
            Node nowNode = que.poll();
            int now = nowNode.targetNode;

            if (visited[now]) {
                continue; // 이미 방문한 노드는 건너뜀
            }

            visited[now] = true;

            for (Node n : arr[now]) {
                if (!visited[n.targetNode] && dist[n.targetNode] > dist[now] + n.weight) {
                    dist[n.targetNode] = dist[now] + n.weight;
                    que.add(new Node(n.targetNode, dist[n.targetNode]));
                }
            }
        }

        return dist[end];
    }
}
