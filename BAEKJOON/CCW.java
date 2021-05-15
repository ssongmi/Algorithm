import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCW {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		Point[] point = new Point[3];
		int maxX= Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			point[i] = new Point(x, y);
			
		}
		int s = (point[1].x-point[0].x)*(point[2].y-point[0].y) - (point[1].y-point[0].y)*(point[2].x-point[0].x);
		
		if(s < 0) {
			System.out.println(-1);
		}else if(s == 0) {
			System.out.println(0);
		}else {
			System.out.println(1);
		}
	}
}
