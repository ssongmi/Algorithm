import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 민석이의과제체크하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			String str = bf.readLine().trim();
			int N = Integer.parseInt(str.split(" ")[0]);
			int K = Integer.parseInt(str.split(" ")[1]);
			
			boolean[] students = new boolean[N+1];
			String[] tmp = bf.readLine().trim().split(" ");
			for(int i = 0; i < tmp.length; i++) {
				students[Integer.parseInt(tmp[i])] = true;
			}
			System.out.print("#" + tc + " ");
			for(int i = 1; i < students.length; i++)
				if(!students[i])
					System.out.print(i + " ");
			System.out.println();
		}
	}
}
