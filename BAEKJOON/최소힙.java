import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소힙 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 숫자의 개수를 받고
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		// 주어진 개수만큼 숫자를 받으면서
		for(int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			
			// 그 숫자가 0이면 큐의 첫번째 숫자를 출력에 넣어주고
			if(value == 0) {
				 if(q.size() == 0) {
					 // 큐에 들어있는게 없으면 0을 출력으로 넣어주고
					 sb.append("0\n");
				 }else {
					 sb.append(q.poll()+"\n");
				 }
			}else {
				// 0이 아니면 큐에 숫자를 넣어줌			
				q.add(value);
			}
		}
		System.out.println(sb);
	}
}
