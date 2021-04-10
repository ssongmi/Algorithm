import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 쉽게푸는문제 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb =new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int[] list = new int[1001];
		int idx = 0;
		int i = 1;
		out :while(true) {
			for(int j = 0; j < i; j++) {
				list[idx++] = i;
				if(idx > 1000) break out;
			}
			i++;
		}
//		System.out.println(Arrays.toString(list));
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		int res = 0;
		for(int k = start; k <= end; k++) {
			res += list[k];
		}
		System.out.println(res);
	}
	
	
}
