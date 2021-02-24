import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 늘어지는소리만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수 입력
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 수 만큼 반복하면서
		for(int tc = 1; tc <= T; tc++) {
			// arraylist에 문자열을 입력받고
			ArrayList<String> str = new ArrayList<>();
			String[] temp = br.readLine().split("");
			for(int i = 0, size = temp.length; i < size; i++)
				str.add(temp[i]);
			
			// 하이픈 개수를 입력받고
			int N = Integer.parseInt(br.readLine());
			
			// 하이픈을 넣을 위치를 입력받고
			temp = br.readLine().split(" ");
			int[] pos = new int[N];
			for(int i = 0; i < N; i++)
				pos[i] = Integer.parseInt(temp[i]);
			
			Arrays.sort(pos);
//			System.out.println(Arrays.toString(pos));
			// arraylist에 위치값을 지정하여 하이픈 넣기			
			for(int i = 0; i < N; i++) {
				str.add(pos[i] + i, "-");;
			}
			sb.append("#" + tc + " ");
			for(int i = 0, size = str.size(); i < size; i++)
				sb.append(str.get(i));
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
