import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 덱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			if("push_front".equals(command)) {
				dq.addFirst(Integer.parseInt(st.nextToken()));
			}else if("push_back".equals(command)) {
				dq.addLast(Integer.parseInt(st.nextToken()));				
			}else if("pop_front".equals(command)) {
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.pollFirst() + "\n");
				}
			}else if("pop_back".equals(command)) {
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.pollLast() + "\n");
				}
			}else if("size".equals(command)) {
				sb.append(dq.size() + "\n");
			}else if("empty".equals(command)) {
				int val = dq.isEmpty() ? 1 : 0;
				sb.append(val + "\n");
			}else if("front".equals(command)) {
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.peekFirst() + "\n");
				}
			}else if("back".equals(command)) {
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.peekLast() + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
