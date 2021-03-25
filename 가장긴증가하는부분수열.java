import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
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
		
		int size = 0;
//		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < N; i++) {
			int idx = Arrays.binarySearch(LIS, 0, size, arr[i]);
			if(idx < 0) idx = Math.abs(idx)-1;
			LIS[idx] = arr[i];
			if(size == idx) ++size;
		}
		System.out.println(size);
	}
}
