import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최대상금 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] card;
	static int size = 0, cnt = 0, max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 수만큼 반복하면서
		for(int tc = 1; tc <= T; tc++) {
			// 숫자들과 교환 횟수를 입력받음
			st = new StringTokenizer(br.readLine());
			
			// 숫자 카드 배열 생성
			String[] temp = st.nextToken().split("");
			card = new int[temp.length];
			size= card.length;
			for(int i = 0, size= temp.length; i < size; i++)
				card[i] = Integer.parseInt(temp[i]);
			
			// 반복 횟수
			cnt = Integer.parseInt(st.nextToken());
			// 완전탐색
			max = 0;
			dfs(0, 0);
			sb.append(String.format("#%d %d\n", tc, max));
		}
		System.out.println(sb);
	}
	private static void dfs(int idx, int count) {
		if(count == cnt) {
			int value = 0; 
			for(int i = 0; i < size; i++) value += card[i]*Math.pow(10, size-i-1);
			max = value > max ? value : max;	
			return;
		}

		for(int i = idx; i < size; i++) {
			for(int j = i+1; j < size; j++) {
				if(count != 0 && card[i] >card[j]) continue;	
				swap(i, j);
				dfs(i, count+1);
				swap(i, j);				
			}
			
		}
	}
	private static void swap(int i, int j) {
		int temp = card[i];
		card[i] = card[j];
		card[j] = temp;
	}
}
