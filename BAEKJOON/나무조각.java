import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무조각 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[5];
		
		for(int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		out : while(true) {
			boolean flag = false;
			for(int i = 0; i < 4; i++) {
				if(arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					flag = true;
				}
				if(flag) {
					for(int j = 0; j < 5; j++) {
						sb.append(arr[j] + " ");
					}
					sb.append("\n");
					flag = false;
				}
				
				int cnt = 0;
				for(int j = 0; j < 5; j++) {
					if(arr[j] == j+1) cnt++;
				}
				if(cnt == 5) break out;
			}
		}
		System.out.println(sb);
	}
}
