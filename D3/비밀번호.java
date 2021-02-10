import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 비밀번호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			// 암호문 길이
			int N = Integer.parseInt(st.nextToken());
			
			// 암호문
			char[] tmp = st.nextToken().toCharArray();
			
			// 암호문을 스택으로 관리
			Stack<Character> pw = new Stack<>();
			
			// 처음 원소를 넣어줌 → stack이 null이면 값을 비교할 수 없으므로
			pw.push(tmp[0]);
			// 첫번째 원소를 이미 넣어줬기 때문에 인덱스는 1부터 시작
			int idx = 1;
			while(idx < tmp.length) {
				// idx가 배열 끝에 도달할때까지 만약 들어가려는 요소와 스택의 마지막 요소가 같으면 스택 요소를 하나 뺌
				if(!pw.isEmpty() && pw.peek().equals(tmp[idx])) {
					pw.pop();					
				}
				// 같지 않다면 스택에 넣어줌
				else {
					pw.push(tmp[idx]);
				}
				idx++;
			}
			sb.append("#" + tc + " " + pw.toString().replace(", ","").replace("[", "").replace("]","") + "\n");
		}
		System.out.println(sb);
	}
}
