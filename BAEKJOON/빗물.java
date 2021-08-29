import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int[] arr = new int[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < C-1; i++) {
			int left = 0;
			int right = 0;
			int cur = arr[i];
			
			for(int j = 0; j < i; j++) {
				left = Math.max(left, arr[j]);
			}
			
			for(int j = C-1; j > i; j-- ) {
				right = Math.max(right, arr[j]);
			}
			
			System.out.println("left = " + left + " right = " + right + " cur = " + cur);
			if(cur < left && cur < right) {
				sum += (Math.min(left, right) - cur);
			}
		}
		System.out.println(sum);
	}
}
