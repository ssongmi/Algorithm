import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치킨배달 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] map;
	static int N, M;
	static boolean[][] v;
	static boolean[] selected;
	static ArrayList<Point> home = new ArrayList<>();
	static ArrayList<Point> chi = new ArrayList<>();	
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// N:행렬의 크기  , M:살아남을 수 있는 치킨집의 최대 개수
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 행렬 입력받으면서 집의 좌표를 배열로 저장
				if(map[i][j] == 1) home.add(new Point(i, j));
				// 행렬을 입력받으면서 치킨집의 좌표 배열로 저장
				else if(map[i][j] == 2) chi.add(new Point(i,j));
			}
		}
		selected = new boolean[chi.size()];
		powerset(0);
		System.out.println(ans);
	}

	// 치킨집을 부분집합으로 뽑으면서
	private static void powerset(int idx) {
		if(idx == chi.size()) {
			int cnt = 0;
			for(int i = 0, size = chi.size(); i < size; i++) {
				if(selected[i]) cnt++;
			}
			// 뽑힌 치킨집의 개수가 M개를 넘으면 그냥 return 시키고
			if(cnt > M || cnt== 0) return;
			
			// 넘지 않았을 때 뽑힌 치킨집들로 부터의 거리를 구해서 갱신
			int val = calc(selected);
			ans = ans > val ? val : ans;
			return;
		}
		selected[idx] = true;
		powerset(idx+1);
		selected[idx] = false;
		powerset(idx+1);
	}
	static int ans = Integer.MAX_VALUE;
	private static int calc(boolean[] sel) {
		int sum = 0;
	
		for(int i = 0, size = home.size(); i < size; i++ ) {
			int min = Integer.MAX_VALUE;
			// 집마다 선택된 치킨집으로부터의 최소 거리를 구함
			for(int j = 0, size2 = chi.size(); j < size2; j++) {
				if(selected[j]) {
					int diff = Math.abs(home.get(i).r - chi.get(j).r)
					+ Math.abs(home.get(i).c - chi.get(j).c); 
					min = min > diff ? diff : min;
				}
			}
			sum += min;
		}
		return sum;
		
	}
}
