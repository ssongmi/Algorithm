import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모음이보이지않는사람 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] c = {"a","e","i","o","u"};
		int T = Integer.parseInt(bf.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			String str = bf.readLine().trim();
			for(int i =0; i < c.length; i++) {
				str = str.replace(c[i],"");
			}
			System.out.println("#" + tc + "" + str);
		}
	}
	
}
