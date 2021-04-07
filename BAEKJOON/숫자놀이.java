import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자놀이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static String[] alphabet = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static class Alphabet implements Comparable<Alphabet>{
		int number;
		String al = "";
		// 숫자를 넘겨주면 그걸 알파벳 구성으로 만들어줌
		public Alphabet(int number) {
			this.number = number;
			if(number / 10 != 0) {
				al += alphabet[number/10]+ " ";
			}
			al += alphabet[number%10];
		}
		@Override
		public int compareTo(Alphabet o) {
			// 길이를 비교해서 짧은 것들에 맞춰서 비교하고
			// 그 길이 안에서 결정이 안나면 길이가 짧은게 앞에 오게 됨
			int olen = o.al.length();
			int thislen = this.al.length();
			for(int i = 0, size = Math.min(olen, thislen); i < size; i++) {
				if(this.al.charAt(i) != o.al.charAt(i)) return this.al.charAt(i) - o.al.charAt(i);
			}
			return thislen - olen;
		}
		@Override
		public String toString() {
			return "Alphabet [number=" + number + ", al=" + al + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Alphabet[] list = new Alphabet[M-N+1];
		// 알파벳으로 만들어 배열에 넣음
		for(int i = N; i <= M; i++) {
			list[i-N] = new Alphabet(i);
		}
		// compareTo를 구현하였기 때문에 그 규칙에 맞춰 출력
		Arrays.sort(list);
		int cnt = 0;
		for(int i = N; i <= M; i++) {
			cnt++;
			System.out.print(list[i-N].number + " ");
			// 10개로 끊어서 출력
			if(cnt == 10) {
				cnt = 0;
				System.out.println();
			}
		}
	}
	
}
