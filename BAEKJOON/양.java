package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = tmp[j].charAt(0);
			}
		}
//		for(char [] sub : map) System.out.println(Arrays.toString(sub));
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] != '#') Decide(i, j);
			}
		}
		System.out.println(sheep + " " + wolf);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int sheep = 0;
	static int wolf = 0;
	private static void Decide(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		visited[r][c] = true;
		int o = 0;
		int v = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
	
//			System.out.println("nr = "+ p.r +", nc = " + p.c + ", map = " + map[p.r][p.c]);
			if(map[p.r][p.c] == 'o') o++;
			if(map[p.r][p.c] == 'v') v++;
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#' || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q.offer(new Point(nr, nc));
			}
		}
//		System.out.println("o = " + o +", v = " + v);
		if(o > v) sheep += o;
		else if(v >= o) wolf += v;
		
	}
}
