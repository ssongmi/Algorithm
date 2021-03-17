import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.event.ListSelectionEvent;
public class 음식물피하기 {
	static class node{
		int x, y;
		
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "node [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, K;
	static ArrayList<node> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// N, M, K를 입력받고
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 쓰레기 정보를 입력받아 map에 표현
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new node(r, c));
		}

		// BFS방식으로 접근
		int ans = setPos();
		System.out.println(ans);
	}
	private static int setPos() {
		int max = Integer.MIN_VALUE;
		while(list.size() != 0) {
			node cur = list.get(0);
			list.remove(cur);
			int size = calArea(cur.x, cur.y);
			max = Math.max(max, size);			
		}
		
		return max;
		
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static int calArea(int r, int c) {
		Queue<node> q = new LinkedList<>();
		q.offer(new node(r, c));
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			node cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nr = cur.x + dr[i];
				int nc = cur.y + dc[i];
				
				// 같은 노드를 찾으면
				for(int j = 0, size = list.size(); j <size; j++ ) {
					
					if(nr == list.get(j).x && nc == list.get(j).y) {		
						list.remove(j);
						q.offer(new node(nr, nc));
						break;
					}	
				}
				
			}
		}
		
		return cnt;
	}
}
