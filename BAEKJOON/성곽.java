import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 성곽 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int[] dir = {1, 2, 4, 8};
	static int[][] adj;
	static int[][] roomInfo;
	static int N, M;
	static int maxSize = Integer.MIN_VALUE;
	static int roomCnt = 0;
	static int mergedMaxSize = Integer.MIN_VALUE;
	static int roomNumber = 0;
	static ArrayList<Integer> roomSize = new ArrayList<>();
	static ArrayList<HashSet> adjRoom = new ArrayList<>();
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		adj = new int[N][M];
		roomInfo = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		adjRoom.add(new HashSet<Integer>());
		roomSize.add(0);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(roomInfo[i][j] == 0) {
					int size = bfs(i, j, ++roomNumber);
					roomSize.add(size);
					maxSize = Math.max(maxSize, size);
				}
			}
		}
		
		for(int i = 1; i < roomNumber + 1; i++) {
			Iterator itr = adjRoom.get(i).iterator();
			while(itr.hasNext()) {
				int adjR = (int)itr.next();
				mergedMaxSize = Math.max(roomSize.get(i) + roomSize.get(adjR), mergedMaxSize);
			}
		}
		sb.append(roomNumber).append("\n").append(maxSize).append("\n").append(mergedMaxSize);
		System.out.println(sb);
	}
	private static int bfs(int r, int c, int num) {

		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		roomInfo[r][c] = num;
		int size = 0;
		adjRoom.add(new HashSet<Integer>());
		while(!q.isEmpty()) {
			Point p = q.poll();
			size++;
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nr > N-1 || nc < 0 || nc > M-1) continue;
				if(roomInfo[nr][nc] != 0 && roomInfo[nr][nc] != num) {
					adjRoom.get(num).add(roomInfo[nr][nc]);
				}
				if((adj[p.r][p.c] & dir[i]) == 0 && roomInfo[nr][nc] == 0) {
					roomInfo[nr][nc] = num;
					q.offer(new Point(nr, nc));
				}
			}
		}
		
		return size;
	}

}
