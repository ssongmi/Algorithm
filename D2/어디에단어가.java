import java.util.Arrays;
import java.util.Scanner;

public class 어디에단어가 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int count = 0;
			int[] col = new int[N];
			int[] row = new int[N];
			
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++){
					arr[i][j] = sc.nextInt();
				}
			}
			for(int i = 0; i < N; i++) {
				
				for(int j = 0; j < N; j++){

						if(arr[i][j] == 1) {
							row[i] += arr[i][j];							
							col[j] += arr[i][j];
							System.out.print(Arrays.toString(row));
							if((row[i] == K && j+1 == N) || (row[i] == K && j+1 < N && arr[i][j+1] == 0)) {
								count++;
								System.out.println(count);
							}
							if((col[j] == K && i+1 == N) || (col[j] == K && i+1 < N && arr[i+1][j] == 0)) {
								count++;
							}
						}else {
							row[i] = 0;
							col[j] = 0;
						}
						
				}
				System.out.println();

			}
			
			System.out.println(Arrays.toString(row));
			System.out.println(Arrays.toString(col));
			System.out.println(count);
		}

	}

}
