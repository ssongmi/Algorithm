import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ptr1 = 0;
		int ptr2 = 1;
		int cnt = 2;
		int minCnt = Integer.MAX_VALUE;
		int sum = arr[0] + arr[1];
		while( ptr1 < N) {
			if(sum >= S && minCnt > cnt) minCnt = cnt;
			if(sum >= S) {
				sum -= arr[ptr1++];
				cnt--;
			}else if(sum < S) {
				ptr2++;
				if(ptr2 >= N) break;
				else sum += arr[ptr2];
				cnt++;
			}
		}
		if(minCnt == Integer.MAX_VALUE)System.out.println(0);
		else System.out.println(minCnt);
	}
}
