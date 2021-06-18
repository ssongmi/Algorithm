import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 순회강연 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		
		Lecture[] ls = new Lecture[N];
		int maxDay = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			if(day > maxDay) maxDay = day;
			ls[i] = new Lecture(price, day);
		}

		Arrays.sort(ls);
		
		int res = 0;
		boolean[] check = new boolean[maxDay+1];
		for(int i = 0; i < N; i++) {
			for(int j = ls[i].d; j >= 1; j--) {
				if(!check[j]) {
					check[j] = true;
					res += ls[i].p;
					break;
				}
			}
		}
		
		System.out.println(res);
		
	}
	static class Lecture implements Comparable<Lecture>{
		int p,d;

		public Lecture(int p, int d) {
			super();
			this.p = p;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Lecture [d=" + d + ", p=" + p + "]";
		}

		@Override
		public int compareTo(Lecture o) {
			if(this.p != o.p) return o.p - this.p;
			return o.d - this.d;
		}
		
	}
}
