import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 두문자어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			String[] words = br.readLine().split(" ");
			for(int i = 0; i < words.length; i++) {
				sb.append(Character.toString(words[i].charAt(0)).toUpperCase());
			}
			System.out.println("#" + tc + " " + sb);
		}

	}

}
