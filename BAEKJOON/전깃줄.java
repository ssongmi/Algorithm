import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 전깃줄 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[501];
		int[] LIS = new int[501];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list[idx] = value;
		}
//		System.out.println(Arrays.toString(list));
		int size = 0;
		for(int i = 0; i < 501; i++) {
			if(list[i] == 0) continue;
			int idx = Arrays.binarySearch(LIS, 0, size, list[i]);
//			System.out.println(idx);
			idx = Math.abs(idx) - 1;
			LIS[idx] = list[i];
			if(size == idx) ++size;
		}
//		System.out.println(Arrays.toString(LIS));
		System.out.println(N-size);
	}
}
