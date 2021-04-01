import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴바이토닉부분수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] list = new int[N];
		st = new StringTokenizer(br.readLine());
//		int maxIdx = 0;
//		int max = 0;
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for(int k = 0; k < N; k++) {
			int[] LIS = new int[N];
			int[] LIS2 = new int[N];
			int size = 0;
			int size2 = N-1;
			for(int i = 0; i < N; i++) {
				if(i <= k) {
					int idx = Arrays.binarySearch(LIS, 0, size,list[i]);
					if(idx < 0) idx = Math.abs(idx)-1;	
					LIS[idx] = list[i];
					if(idx == size) size++;
				}else {
					if(list[i] == LIS[size-1]) continue;
					int idx = Arrays.binarySearch(LIS2, size2, N,list[i]);
					if(idx < 0) idx = Math.abs(idx)-2;	
					LIS2[idx] = list[i];
					if(idx == size2) size2--;
				}
			}
//			System.out.println("k = " + k);
//			System.out.println(Arrays.toString(LIS));
//			System.out.println(Arrays.toString(LIS2));
			int res = size+N-size2-1;
			ans = ans > res ? ans : res;
		}
		System.out.println(ans);
		
	}
}
