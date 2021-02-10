import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 새샘이의735게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static HashSet<Integer> sum;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수 입력
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			// 숫자들을 배열로 입력 받음
			String[] tmp = br.readLine().split(" ");
			arr = new int[tmp.length];
			for(int i = 0; i < tmp.length; i++)
				arr[i] = Integer.parseInt(tmp[i]);
			sum= new HashSet<>();
			getSum(0,0,0);
			Object[] newArray = sum.toArray();
			Arrays.sort(newArray);
			sb.append("#" + tc + " " + newArray[sum.size()-5] + "\n");
		}
		System.out.println(sb);
		
	}
	static void getSum(int idx, int cnt, int total) {
		if(idx == arr.length) {
			if(cnt == 3)
				sum.add(total);
			return;
		}
		getSum(idx+1, cnt + 1, total+arr[idx]);
		getSum(idx+1, cnt , total);
	}
}
