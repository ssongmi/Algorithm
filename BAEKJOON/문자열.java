import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		//문자열 A와 B를 저장
		st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int lenA = A.length();
		int lenB = B.length();
		int cnt = Integer.MAX_VALUE;
		// 문자열 A와 B의 길이가 같다면
		if(lenA == lenB) {
			cnt = 0;
			// 차례대로 검사하며 다른 값을 가지는 곳의 개수를 계산
			for(int i = 0; i < lenA; i++) {
				if(A.charAt(i) != B.charAt(i)) cnt++;
			}
			// 문자열 A와 B의 길이가 다르다면
		}else {
			// A를 B의 한자리씩 밀어가며 차이가 가장 적게 나는 곳을 찾음
			for(int i = 0, size=lenB-lenA+1; i <size;i++ ) {
				int temp = 0;
				for(int j = 0; j < lenA; j++) {
					if(A.charAt(j) != B.charAt(i+j)) temp++;
				}
				cnt = Math.min(cnt, temp);
			}
		}
		System.out.println(cnt);
		
	}
}
