import java.util.Scanner;

public class 파리퇴치2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j< N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int ans = 0;
			for(int i =0; i <= N-M; i++) {
				for(int j = 0; j <= N-M; j++) {
					int sum = 0;
					for(int m = i; m < i+M; m++) {
						for(int n = j; n < j+M; n++) {
							sum += arr[m][n];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			System.out.println(ans);
		}
	}

}
