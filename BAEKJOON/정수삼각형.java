

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수삼각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++)
			Arrays.fill(map[i], -1);
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j = 0, size = tmp.length; j < size; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
//		for(int[] sub : map){
//			System.out.println(Arrays.toString(sub));
//		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == 0 && j == 0 ) continue;
				int max = Integer.MIN_VALUE;
				if(map[i][j] != -1) {
					if(i-1 >= 0 && j-1 >= 0 && map[i-1][j-1] > max) max = map[i-1][j-1];
					if(i-1 >= 0 && map[i-1][j] > max) max = map[i-1][j];
					map[i][j] += max;
				}
			}
		}
//		for(int[] sub : map){
//			System.out.println(Arrays.toString(sub));
//		}
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++)
			res = Math.max(res, map[N-1][i]);
		System.out.println(res);
		
	}
}
