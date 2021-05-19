import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소가길을건너간이유5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		boolean[] arr = new boolean[N+1]; // false면 정상 true면 고장
		int cnt = 0;
		for(int i = 0; i < B; i++) {
			int num =  Integer.parseInt(br.readLine());
			if(num < K+1) cnt++;
			arr[num] = true;
		}
		
		int ptr1 = 1;
		int ptr2 = K;
		int min = K;
		while(ptr2 < N) {
			if(!arr[ptr1] && arr[ptr2+1]) {
				cnt++;
			}else if(arr[ptr1] && !arr[ptr2+1]) {
				cnt--;
			}
			min = cnt < min ? cnt : min;
			ptr1++;
			ptr2++;
		}
		System.out.println(min);
	}
}
