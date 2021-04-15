import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형탈출 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, sr, sc, h, w, fr,fc;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Point{
		int sr, sc, er,ec, cnt;

		public Point(int sr, int sc, int er, int ec) {
			super();
			this.sr = sr;
			this.sc = sc;
			this.er = er;
			this.ec = ec;
		}

		public Point(int sr, int sc, int er, int ec, int cnt) {
			super();
			this.sr = sr;
			this.sc = sc;
			this.er = er;
			this.ec = ec;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		v =new boolean[N+1][M+1];
		for(int i = 1; i <N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < M+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		fr = Integer.parseInt(st.nextToken());
		fc = Integer.parseInt(st.nextToken());
		bfs(sr, sc, sr+h-1, sc+w-1);
		if(min == Integer.MAX_VALUE)System.out.println("-1");
		else System.out.println(min);
		
	}
	static int min = Integer.MAX_VALUE;
	
	private static void bfs(int sr, int sc, int er, int ec) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(sr, sc, er, ec, 0));
		v[sr][sc] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(cur.sr == fr && cur.sc == fc) {
				min = min > cur.cnt ? cur.cnt : min;
				return;
			}
			for(int i = 0; i < 4; i++) {
				int nsr = cur.sr + dr[i];
				int nsc = cur.sc + dc[i];
				int ner = cur.er + dr[i];
				int nec = cur.ec + dc[i];
				
				// 범위 밖으로 나갈때
				if(nsr < 1 || nsr > N || nsc < 1 || nsc > M || ner < 1 || ner > N || nec < 1 || nec > M || v[nsr][nsc])continue;
				
				// 이동하려는 자리 중 하나라도 1일 때
				if(check(nsr, nsc, ner, nec)) continue;
				v[nsr][nsc] = true;
				q.offer(new Point(nsr, nsc, ner, nec, cur.cnt+1));
			}
		}
	}

	private static boolean check(int nsr, int nsc, int ner, int nec) {
		for(int i = nsr; i <= ner ; i++) {
			for(int j = nsc; j <= nec; j++) {
				if(map[i][j] == 1) return true;
			}
		}
		return false;
	}

}
