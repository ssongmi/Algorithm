import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 저울 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, total = 0;
	static int[] list;
	static boolean[] isSelected, check;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			total += list[i];
		}

		Arrays.sort(list);
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(sum + 2 <= list[i]) break;
			sum += list[i];
		}
		System.out.println(sum+1);
	}
}
