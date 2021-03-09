import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 슬라임합치기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] slime = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			slime[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(slime);
		int score = 0;
		int size = slime[0];
		for(int i = 1; i < N; i++) {
			score += size*slime[i];
			size += slime[i]; 
		}
		System.out.println(score);
	}
}
