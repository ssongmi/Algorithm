import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 대칭차집합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int sizeA = Integer.parseInt(st.nextToken());
		int sizeB = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> setA = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < sizeA; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		

		HashSet<Integer> setB = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < sizeB; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}
		
		HashSet<Integer> setTemp = new HashSet<>();
		setTemp.addAll(setA);
		setA.removeAll(setB);
		setB.removeAll(setTemp);
		System.out.println(setA.size() + setB.size());
	}
}
