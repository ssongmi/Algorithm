import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 재관이의대량할인 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 수만큼 반복하며
		for(int tc = 1; tc <= T; tc++) {
			// N을 입력받고
			int N = Integer.parseInt(br.readLine());
			
			// N칸짜리 배열을 만들어서
			int[] price = new int[N];
			int totalPrice = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				// N벌의 옷 가격을 입력받고
				price[i] = Integer.parseInt(st.nextToken());
				// 입력받음과 동시에 전체 가격 합을 구하고
				totalPrice += price[i];
			}
			
			// 가격들을 정렬시켜서 
			Arrays.sort(price);
			
			// 제일 비싼 것 부터 3개씩 띄어가며 묶인 3개중 가장 작은 가격을 차감해줌
			int idx = 0;
			for(int i = N-1; i >= 0; i--) {
				if(idx == 2) totalPrice -= price[i];
				idx = (idx+1)%3;
			}
			sb.append(String.format("#%d %d\n", tc, totalPrice));
		}
		System.out.println(sb);
	}
}
