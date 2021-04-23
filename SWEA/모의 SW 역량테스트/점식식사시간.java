import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 점식식사시간 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int[] step;
	static int[] t;
	static ArrayList<Point> list;
	static ArrayList<Point> ent;
	
	static class Point implements Comparable<Point>{
		int r, c, dist;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			
			return this.dist - o.dist;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", dist=" + dist + "]";
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			ent = new ArrayList<>();
			
			map = new int[N][N];
			t = new int[2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) list.add(new Point(i, j));
					else if(map[i][j] != 0) ent.add(new Point(i, j));
				}
			}
			step = new int[list.size()];
			
			// 각 사람마다 어느 계단을 이용할지를 중복순열을 통해 결정
			min = Integer.MAX_VALUE;
			perm(0);
			sb.append(String.format("#%d %d\n", tc, min));
		}
		System.out.println(sb);
	}
	static int min = Integer.MAX_VALUE;
	private static void perm(int cnt) {
		if(cnt == list.size()) {
//			System.out.println(Arrays.toString(step));
			calc(0);
			calc(1);
			min = Math.min(min, Math.max(t[0], t[1]));
			return;
		}
		for(int i = 0; i < 2; i++) {
			step[cnt] = i;
			perm(cnt+1);
		}
	}
	private static void calc(int val) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		Point curStep = ent.get(val);
		for(int i = 0, size = list.size(); i < size; i++) {
			if(step[i] == val) {
				Point cur = list.get(i);
				q.offer(new Point(cur.r, cur.c, Math.abs(cur.r-curStep.r) + Math.abs(cur.c - curStep.c)));				
			}
		}
		ArrayList<Point> temp= new ArrayList<>();
		// 가까운 순서부터 나오니까
		int cnt = 0;
		int time = 0;
		int num = map[curStep.r][curStep.c];
		while(!q.isEmpty()) {
			int size = q.size();
			time++;
			while(size--> 0) {
//				System.out.println("time = " + time);
//				System.out.println(Arrays.toString(q.toArray()));
				Point cur = q.poll();
				// 아직 계단 입구에 도착하지 않았을 때
				
				if(cur.dist - 1 > 0 ) temp.add(new Point(cur.r , cur.c, cur.dist-1));
				else if(cur.dist == 0){ // 계단에 이제 막 도착
					if(cnt < 3) { // 계단을 이동
						cnt++;
						temp.add(new Point(cur.r, cur.c, cur.dist-1));
					}else { // 계단에 도착했지만 이동할 수 없을 때
						temp.add(new Point(cur.r, cur.c, 0));
					}
				}else if(cur.dist > -num) {
					temp.add(new Point(cur.r, cur.c, cur.dist-1));
				}else if(cur.dist == -num) {
					cnt--; // 계단 탈출
				}
			}
			q.addAll(temp);
			temp.clear();
		}
		t[val] = time;
		
	}
}
