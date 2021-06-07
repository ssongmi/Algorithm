import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 나이순정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Member implements Comparable<Member>{
		int idx, age;
		String name;
		public Member(int idx, int age, String name) {
			super();
			this.idx = idx;
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(Member o) {
			if(this.age != o.age) return this.age - o.age;
			return this.idx - o.idx;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Member> q = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Member m = new Member(i, age, name);
			q.offer(m);
		}
		
		for(int i = 0; i < N; i++) {
			Member m = q.poll();
			sb.append(m.age).append(" ").append(m.name).append("\n");
		}
		System.out.println(sb);
	}
}
