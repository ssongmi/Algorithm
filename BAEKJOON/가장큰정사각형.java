import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장큰정사각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[2][M];
		int[][] size = new int[2][M];
		String[] tmp = br.readLine().split("");
		
		int max = 0;
		// 첫째줄만 입력
		for(int i = 0; i < M; i++) {
			map[0][i] = Integer.parseInt(tmp[i]);
			size[0][i] = map[0][i];
			max = max > size[0][i] ? max : size[0][i];
		}
		
		for(int i = 1; i < N; i++) {
			String[] temp = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[1][j] = Integer.parseInt(temp[j]);
				size[1][j] = map[1][j];
				if(j-1 >= 0 && size[0][j-1] != 0 && size[0][j] != 0 && size[1][j-1] != 0 && size[1][j] != 0) {
					size[1][j] = Math.min(Math.min(size[0][j-1], size[0][j]), size[1][j-1]) + 1;
					max = max > size[1][j] ? max : size[1][j];
				}
			}
//			for(int[] sub : size)
//			System.out.println(Arrays.toString(sub));
			map[0] = Arrays.copyOf(map[1], M);
			size[0] = Arrays.copyOf(size[1], M);
		}
		
//		for(int[] sub : size)
//			System.out.println(Arrays.toString(sub));
		System.out.println(max*max);
	}
}
