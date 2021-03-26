package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[][] adj;
	static class Point {
		int r, c, len;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		public Point(int r, int c, int len) {
			super();
			this.r = r;
			this.c = c;
			this.len = len;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		// DFS 해당 섬 번호 표시
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 각 섬을 2부터 번호로 표시
		int iNumber = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					setMark(i, j, iNumber);
					iNumber += 1;
				}
			}
		}
//		for(int[] sub : map)
//			System.out.println(Arrays.toString(sub));
		adj = new int[iNumber-2][iNumber-2];
		// 인접행렬 만들기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) getDistance(i, j, map[i][j], 0);
			}
		}
//		for(int[] sub : adj)
//			System.out.println(Arrays.toString(sub));
		
		
		// 좌우로 쭉 가보기
		// 가다가 내 섬과 같은 번호면 멈추고
		// 다른 섬이 나오면 그때의 거리를 인접 행렬에 넣기
		
		for (int i = 0; i < iNumber-2; i++) {
			for (int j = 0; j < iNumber-2; j++) {
				if(i != j && adj[i][j] == 0) adj[i][j] = 99999;
			}
		}
		

		iNumber -= 2; // 제대로

		// 프림으로 MST 구하기
		int[] minEdge = new int[iNumber];
		boolean[] v = new boolean[iNumber];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		int res = 0;
		minEdge[0] = 0;
		for(int c = 0; c < iNumber; c++) {
			int min = Integer.MAX_VALUE;
			int minV = 0;
			for(int i = 0; i < iNumber; i++) {
				if(!v[i] && min > minEdge[i]) {
					min = minEdge[i];
					minV = i;
				}
			}
			
			res += min;
			v[minV] = true;
			
			for(int i = 0; i <iNumber;i++ ) {
				if(!v[i] && adj[minV][i] != 0 && minEdge[i] > adj[minV][i]) {
					minEdge[i] = adj[minV][i];
				}
			}
		}
		System.out.println(res >= 600 ? -1 : res);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 섬을 번호별로 표시
	private static void setMark(int r, int c, int iNumber) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		map[r][c] = iNumber;
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == iNumber || map[nr][nc] == 0) continue;
				map[nr][nc] = iNumber;
				q.offer(new Point(nr, nc));
			}
		}
	}
	private static void getDistance(int r, int c , int iNumber, int len) {
		for(int i = 0; i < 4; i++) {
			Counter(r, c, iNumber, i);	
		}
	}
	private static void Counter(int r, int c, int iNumber, int d) {
		// 상하좌우로 보는데 만약에 길이 없으면 중단하고
		// 내 섬하고 동일한 번호가 나와도 중단하고
		// 0으로 이루어지다가 다른 섬이 나왔을 때만 그 값 기록
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c, -1));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(map[p.r][p.c] != 0 && map[p.r][p.c] != iNumber) {
				if(p.len != 1) {
					
					int original = adj[map[p.r][p.c]-2][iNumber-2];
					if(original == 0) {
						adj[map[p.r][p.c]-2][iNumber-2] = p.len;
						adj[iNumber-2][map[p.r][p.c]-2] = p.len;					
					}
					else {
						adj[map[p.r][p.c]-2][iNumber-2] = Math.min(p.len, original);
						adj[iNumber-2][map[p.r][p.c]-2] = Math.min(p.len, original);											
					}
				}
				break;
			}
			int nr = p.r + dr[d];
			int nc = p.c + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == iNumber) break;
			q.offer(new Point(nr, nc, p.len+1));
		}
	}
	

}
