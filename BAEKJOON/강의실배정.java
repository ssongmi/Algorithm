import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Lesson implements Comparable<Lesson>{
		int start, end;

		public Lesson(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lesson o) {
			if(this.start != o.start) return this.start-o.start;
			return o.end - this.end ;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<Lesson> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Lesson(start, end));
		}
		Collections.sort(list);
		for(int i = 0; i < N; i++) {
			Lesson cur = list.get(i);
			if(!pq.isEmpty() && pq.peek() <= cur.start) {
				pq.poll();
			}
			pq.offer(cur.end);
		}
		System.out.println(pq.size());
	}
}
