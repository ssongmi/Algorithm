import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 소수구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		boolean[] v = new boolean[M+1];
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i = 2; i <= M; i++) {
			if(!v[i]) {
				primes.add(i);
				for(int j = i+i; j <= M; j+=i) {
					v[j] = true;
				}
			}
		}
		for(int i : primes) {
			if(i >= N && i <= M)sb.append(i + "\n");
		}
		System.out.println(sb);
	}
}
