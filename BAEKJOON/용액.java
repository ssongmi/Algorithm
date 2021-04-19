import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ptr1 = 0;
		int ptr2 = N-1;
		int r = 0, l = 0;
		int min = Integer.MAX_VALUE;
		
		while(ptr1 < ptr2) {
			int temp = arr[ptr1] + arr[ptr2];
			if(Math.abs(temp) < Math.abs(min)) {
				min = temp;
				l = ptr1;
				r = ptr2;
			}
			
			if(min == 0) break;
			
			if(temp > 0) ptr2--;
			else if(temp < 0) ptr1++;
		}
		
		System.out.println(arr[l] + " " + arr[r]);
	}
}
