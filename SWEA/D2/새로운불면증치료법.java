import java.util.Arrays;
import java.util.Scanner;

public class 새로운불면증치료법 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String s = sc.nextLine();
			int N = Integer.parseInt(s);
			int temp = N;
			boolean[] visited = new boolean[10];
			int sum = 0;
			int idx = 1;
			boolean flag = true;

			while(true){
				for(int i = 0; i< s.length(); i++) {
					int tmp = Integer.parseInt(s.substring(i, i+1));
					if(visited[tmp] == false) {
						sum++;
						visited[tmp] = true;
					}
				}
				if(sum == 10) break;
				idx++;
				s = Integer.toString(N*idx);
			}
			System.out.println("#" + tc + " " + s);
			
		}
	}

}
