import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 과제{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class homework implements Comparable<homework>{
		int date, score;

		public homework(int date, int score) {
			super();
			this.date = date;
			this.score = score;
		}

		@Override
		public int compareTo(homework o) {
			if(this.date != o.date) return -this.date + o.date;
			return -this.score + o.score;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<homework> list = new ArrayList<>();
		
		int maxDay = 1;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int date = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			if(date > maxDay) maxDay = date;
			list.add(new homework(date, score));
		}
		Collections.sort(list);
		
		int res = 0;
		
		for(int i = maxDay; i >= 1; i--) {
			homework h = new homework(0,0);
			for(homework hw : list) {
				if(hw.date >= i && h.score < hw.score) {
					h = hw;
				}
			}
			res += h.score;
			list.remove(h);
		}
		System.out.println(res);
	}
	
}
