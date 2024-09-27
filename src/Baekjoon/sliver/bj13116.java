package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj13116 {
	static ArrayList<Integer> tree[];
	static int[] depth;
	static int kmax;
	static int[][] parent;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = 1023; // 노드 수
		
		tree = new ArrayList[N+1]; 	
		for(int i=1 ; i<=N ; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i=1 ; i<=N/2 ; i++) { // 인접리스트에 그래프 데이터 추가
			tree[i].add(2*i);
			tree[i].add((2*i)+1);
		}
		
		depth = new int[N+1];
		visited = new boolean[N+1];
		int temp = 1;
		kmax = 0;
		while(temp <= N) { // 최대 가능 depth 구하기
			temp <<= 1;
			kmax++;
		}
		
		System.out.print("kmax : "+kmax);
		parent = new int[kmax+1][N+1];
		BFS(1);
		for(int k=1 ; k<=kmax ; k++) {
			for(int n=1 ; n<=N ; n++) {
				parent[k][n] = parent[k-1][parent[k-1][n]];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ; i<T ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(executeLCA(a, b) * 10).append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static int executeLCA(int a, int b) {
		if(depth[a] > depth[b]) { // 더 깊은 depth가 b가 되도록 변경하기
			int temp = a;
			a = b;
			b = temp;
		}
		
		for(int k=kmax ; k>=0 ; k--) { // depth를 제곱근으로 빠르게 맞추기
			if(Math.pow(2, k) <= depth[b]-depth[a]) {
				if(depth[a] <= depth[parent[k][b]]) {
					b = parent[k][b];
				}
			}
		}
		
		for(int k=kmax ; k>=0 ; k--) {
			if(parent[k][a] != parent[k][b]) {
				a = parent[k][a];
				b = parent[k][b];
			}
		}
		
		int LCA = a;
		if(a != b) LCA = parent[0][LCA];
		
		return LCA;
	}
	
	private static void BFS(int node) {
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.add(node);
		visited[node] = true;
		int level = 1;
		int now_size = 1;
		int count = 0;
		
		while(!que.isEmpty()) {
			int now_node = que.poll();
			for(int next : tree[now_node]) {
				if(!visited[next]) {
					visited[next] = true;
					que.add(next);
					parent[0][next] = now_node; // 부모 노드 저장
					depth[next] = level; // 노드 depth 구하기
				}
			}
			count++;
			if(count == now_size) {
				count = 0;
				now_size = que.size();
				level++;
			}
		}
	}
}
