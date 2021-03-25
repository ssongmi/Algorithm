import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴감소하는부분수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int size = N-1;
//		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < N; i++) {
			int idx = Arrays.binarySearch(LIS, size, N, arr[i]);
//			System.out.println("idx = " + idx + ", size = " + size);
			if(idx < 0) idx = Math.abs(idx)-2;
			LIS[idx] = arr[i];
			if(size == idx) --size;
		}
//		System.out.println(Arrays.toString(LIS));
		System.out.println(N-size-1);
	}
}
