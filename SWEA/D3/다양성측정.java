import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 다양성측정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine().trim();
			String[] arr = str.split("");
			HashSet<Integer> numbers = new HashSet<>();
			for(int i = 0; i < arr.length; i++)
				numbers.add(Integer.parseInt(arr[i]));
			System.out.println("#" + tc + " " + numbers.size());
		}
	}

}
