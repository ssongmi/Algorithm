import java.util.Arrays;
import java.util.Scanner;

public class 파스칼의삼각형 {
	static void drawTriangle(int n) {
		int[][] triangle = new int[n][n];
		triangle[0][0] = 1;
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j-1 >= 0) {
					triangle[i][j] += triangle[i-1][j-1];
				}

				triangle[i][j] += triangle[i-1][j];
			}
		}
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				if(triangle[i][j] == 0) { 
					System.out.print(" ");
					continue;
				}
				System.out.print(triangle[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(sc.nextLine());
			System.out.println("#"+i);
			drawTriangle(N);
		}
	}
}
