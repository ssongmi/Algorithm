import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class string {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String word = br.readLine();
			String sentence = br.readLine();
			
			sentence = sentence.replace(word, "*");
			int cnt = 0;
			for(int i = 0; i < sentence.length(); i++) {
				if(sentence.charAt(i) == '*') {
					cnt++;
					System.out.println("실");
				}
			}
			sb.append(String.format("#%d %d\n", tc,cnt));
		}
		System.out.println(sb);
	}
}
