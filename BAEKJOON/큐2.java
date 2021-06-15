import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 큐2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		Deque<Integer> q = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if("push".equals(command)) {
				int num = Integer.parseInt(st.nextToken());
				q.offer(num);
			}else if("pop".equals(command)) {
				if(q.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(q.poll()+"\n");
				}
			}else if("size".equals(command)) {
				sb.append(q.size()+"\n");
			}else if("empty".equals(command)) {
				sb.append((q.isEmpty() ? 1 : 0) + "\n");
			}else if("front".equals(command)) {
				if(q.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(q.peekFirst()+"\n");
				}
			}else if("back".equals(command)) {
				if(q.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(q.peekLast()+"\n");
				}
			}
		}
		System.out.println(sb);
	}
}
