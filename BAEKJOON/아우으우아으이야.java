import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 아우으우아으이야 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int res = 0;
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			if(y1 >= y2) continue;
			else if(y1 >= x2) y1= y2;
			else {
				res += Math.abs(y1-x1);
				x1 = x2;
				y1 = y2;
			}
		}
		res += Math.abs(y1-x1);
		System.out.println(res);
	}
}
