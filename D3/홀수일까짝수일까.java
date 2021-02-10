import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홀수일까짝수일까 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			String[] number = br.readLine().split("");
			sb.append("#" + tc + " ");
			if(Integer.parseInt(number[number.length-1])%2 == 0)
				sb.append("Even\n");
			else
				sb.append("Odd\n");
		}
		System.out.println(sb);
	}
}
