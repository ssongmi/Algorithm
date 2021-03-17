import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] card;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 상근이의 수를 입력받고
		N = Integer.parseInt(br.readLine());
		
		card = new int[N];
		
		// 상근이 정보를 입력받고
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		// 주어진 카드 수 입력
		int N2 = Integer.parseInt(br.readLine());
		
		// 주어진 카드 정보
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N2; i++) {
			// 상근이가 해당 카드를 가지고 있다면 1
			int number = Integer.parseInt(st.nextToken());
			if(search(number))
				sb.append("1 ");
			else
				sb.append("0 ");
			
		}
		
		System.out.println(sb);
	}
	private static boolean search(int number) {
		int left = 0;
		int right = N-1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(number > card[mid]) {
				left = mid + 1;
			}else if(number < card[mid]) {
				right = mid-1;
			}else return true;
		}
		return false;
	}
}
