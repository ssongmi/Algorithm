import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크게만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		String[] tmp = br.readLine().split("");
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			int cur = Integer.parseInt(tmp[i]);
			while(cnt < K && !stack.isEmpty() && stack.peek() < cur) {
				stack.pop();
				cnt++;
			}
			stack.add(cur);
		}
		for(int i = 0, size = N-K; i < size; i++) {
			sb.append(stack.get(i));
		}
		System.out.println(sb);
	}
}
