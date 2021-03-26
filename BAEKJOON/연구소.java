package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}
	static ArrayList<Point> virus = new ArrayList<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new int[N+1][M+1];
		v = new boolean[N+1][M+1];
		virus = new ArrayList<>();
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < M+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virus.add(new Point(i, j));
			}
		}
		
//		int cnt = 3;
		setWall(3);
		System.out.println(max);
		// 벽을 놔보는 거
		// 2를 확산시키는거
		// 안전영역 크기를 세는 거
		
	}
	static int max = Integer.MIN_VALUE;
	private static void setWall(int cnt) {
		if(cnt == 0) {
			spread();
			int count = Counter();
			if(count > max) max = count;	
			// 맵을 다시 원상복구
			Recover();
			return;
		}
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < M+1; j++) {
				if(map[i][j] == 0 && cnt > 0) {
					map[i][j] = 1;
					setWall(cnt-1);
					map[i][j] = 0;
				}
			}
		}
	}
	// 바이러스 확산시켜보기
	private static void spread() {
		Queue<Point> q = new LinkedList<>();
		for(int i = 0, size = virus.size(); i < size; i++) {
			Point p = virus.get(i);
			v[p.x][p.y] = true;
			q.offer(new Point(p.x, p.y));
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 4; i++) {
				int nr = p.x + dr[i];
				int nc = p.y + dc[i];
				if(nr < 1 || nr >= N+1 || nc < 1 || nc >= M+1 || v[nr][nc] || map[nr][nc] == 1) continue;
				map[nr][nc] = 2;
				v[nr][nc] = true;
				q.offer(new Point(nr, nc));
			}
		}
//		for(int[] sub : map)
//			System.out.println(Arrays.toString(sub));
//		System.out.println("======================================");
		
		
	}
	// 안전영역 개수 세기
	private static int Counter() {
		int cnt = 0;
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < M+1; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	// 맵을 다시 원상복구 시키기
	private static void Recover() {
		// 퍼진 바이러스 자리를 다시 0으로 만들고
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < M+1; j++) {
				if(map[i][j] == 2) map[i][j] = 0;
				v[i][j] = false;
			}
		}
		
		// 원래 바이러스 있던자리 복구
		for(int i = 0, size = virus.size(); i < size; i++ ) {
			Point p = virus.get(i);
			map[p.x][p.y] = 2;
		}
		
	}
}
