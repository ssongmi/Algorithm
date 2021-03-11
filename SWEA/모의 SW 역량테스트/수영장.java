import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수영장 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 수만큼 반복하며
		for(int tc = 1; tc <= T; tc++) {
			// 이용권 가격들을 1일, 1달, 3달, 1년 순서대로 입력받고
			int[] price = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			// 각 달마다 얼만큼씩 이용하는지를 입력받는다.
			int[] month = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < 13; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			// 각 달마다 최소 요금을 저장
			int[] pee = new int[13];
			for(int i = 1; i < 13; i++) {
				// 그 전달의 최소 가격과 현재달에서 1일권, 1달권 , 3달권을 사용했을 때의				
				if(i < 3) {
					// 가격을 비교해서 가장 작은 가격을 더하고
					pee[i] = pee[i-1] + Math.min(price[0]*month[i], price[1]);
				}else {
					// 만약 현재달이 3월이 되면 1달전의 최소 가격과 3달전의 최소가격과 비교
					int temp = Math.min(price[0]*month[i], price[1]);
					pee[i] = Math.min(pee[i-3]+price[2], temp+pee[i-1]);
				}
				// 12월이 되면 1년짜리가 싼지 지금까지 구해온 가격이 싼지 비교
				if(i == 12) {
					pee[i] = Math.min(pee[i], price[3]);
				}
			}
			sb.append(String.format("#%d %d\n", tc, pee[12]));
		}
		System.out.println(sb);
	}
}
