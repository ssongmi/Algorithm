import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피카츄 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		String[] list = {"pi", "ka", "chu"};
		
		for(int i = 0; i < 3; i++) {
			str = str.replaceAll(list[i], "O");
		}
		str = str.replace("O", "");
		if(str.length() == 0) System.out.println("YES");
		else System.out.println("NO");
	}
}
