import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 장애물경주난이도 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine().trim());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine().trim());
			String str = bf.readLine();
			String[] arr = str.split(" ");
			int[] steps = new int[arr.length];
			int up = 0;
			int down = 0;
			for(int i = 0; i < arr.length; i++) {
				steps[i] = Integer.parseInt(arr[i]);
			}
			for(int i = 0; i < arr.length-1; i++) {
				int diff = steps[i] - steps[i+1];
				if(diff < 0 && up < Math.abs(diff) )
					up = Math.abs(diff);
				else if(diff >= 0 && down < diff )
					down = diff;
			}
			System.out.println("#" + tc + " " + up + " " + down);
		}
	}
}
