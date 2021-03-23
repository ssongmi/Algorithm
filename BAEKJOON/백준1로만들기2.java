
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1로만들기2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] D = new int[N+1];
		int[] res = new int[N+1];
		for(int i = 2; i < N+1; i++) {
			int min = Integer.MAX_VALUE;
			if(i%3 == 0 && min > D[i/3] +1) {
				min = D[i/3] + 1;
				res[i] = 3; 
			}
			if(i%2 == 0 && min > D[i/2] + 1) {
				min = D[i/2] + 1;
				res[i] = 2;
			}
			if(i-1 >= 0 && min > D[i-1] + 1) {
				min = D[i-1] + 1;
				res[i] = 1;
			}
			D[i] = min;
		}
		sb.append(D[N] + "\n");
		int num = N;
		while(num >= 1) {
			sb.append(num + " ");
			if(res[num] == 3) {
				num /= 3;
			}else if(res[num] == 2) {
				num /= 2;
			}else if(res[num] == 1){
				num -= 1;
			}else {
				break;
			}
		}
		System.out.println(sb);
	}
}
