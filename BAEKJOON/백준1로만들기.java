
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1로만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] D = new int[N+1];
		for(int i = 2; i < N+1; i++ ) {
			int min = Integer.MAX_VALUE;
			if(i%3 == 0 && min > D[i/3] + 1) min = D[i/3] + 1;
			if(i%2 == 0 && min > D[i/2] + 1) min = D[i/2] + 1;
			if(i-1 >= 0 && min > D[i-1] + 1) min = D[i-1] + 1;
			D[i] = min;
		}
		System.out.println(D[N]);
	}
}
