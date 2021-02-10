import java.util.Arrays;
import java.util.Scanner;

public class 파리퇴치 {
	static int max = 0;
	static int sum = 0;
	static void flap(int[][] arr, int flapper, int r, int c) {
	
		for(int i = 0; i < flapper; i++) {
			for(int j = 0; j < flapper; j++) {
				if(r+flapper < arr.length && c+flapper < arr.length) {
					sum += arr[r+i][c+j];
				} 
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //寃⑹옄 �븳蹂��쓽 湲몄씠
			int flapper = sc.nextInt();
			int[][] arr =  new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(sc.next());
				}
				sc.nextLine();
			}
			
			max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sum = 0;
					flap(arr, flapper, i, j);
					if(sum > max) max = sum;
				}
			}
			
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			System.out.println("#" + tc + " " + max);
			
		}

	}

}
