import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표정렬하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Point implements Comparable<Point>{
		int x, y;

		public Point(int x, int y){
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if(this.x != o.x) return this.x - o.x;
			return this.y - o.y;
		}

		@Override
		public String toString() {
			return  x + " " + y;
		}
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N =Integer.parseInt(br.readLine());
		Point[] list = new Point[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[i] = new Point(x, y);
		}
		Arrays.sort(list);
		for(Point p : list)
			System.out.println(p);

	}
}
