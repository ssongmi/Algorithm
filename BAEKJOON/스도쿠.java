import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스도쿠 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] sudoku = new int[9][9];
	static ArrayList<Point> list = new ArrayList<>();
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if(sudoku[i][j] == 0) list.add(new Point(i, j));
			}
		}
		setNumber(0);
	
		
	
	}
	private static void setNumber(int idx) {
		if(idx == list.size()) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		int r = list.get(idx).r;
		int c = list.get(idx).c;
//		System.out.println(idx);
		for(int i = 1; i < 10; i++) {
			sudoku[r][c] = i;
			// 가로줄 확인			
			// 세로줄 확인
			// 정사각형 확인
			if(checkRow(r) && checkCol(c) && checkBox(r, c)) {
				setNumber(idx+1);
			}
		}
		sudoku[r][c] = 0;
		
	}
	static int[] dr = {0, 1, 2};
	private static boolean checkBox(int r, int c) {
		int sr = r/3;
		int sc = c/3;
		sr *= 3;
		sc *= 3;
		boolean[] v = new boolean[10];
		for(int i = 0; i < 3; i++) {
			int nr = sr+dr[i];
			for(int j = 0; j < 3; j++) {
				int nc = sc + dr[j];
				if(sudoku[nr][nc] != 0 && v[sudoku[nr][nc]]) return false;
				v[sudoku[nr][nc]] = true;
				
			}
		}
		return true;
	}
	private static boolean checkCol(int c) {
		boolean[] v = new boolean[10];
		for(int r = 0; r < 9; r++) {
			if(sudoku[r][c] != 0 && v[sudoku[r][c]]) return false;
			v[sudoku[r][c]] = true;
		}
		return true;
	}
	// 가로줄 확인
	private static boolean checkRow(int r) {
		boolean[] v = new boolean[10];
		for(int c = 0; c < 9; c++) {
			if(sudoku[r][c] != 0 && v[sudoku[r][c]]) return false;
			v[sudoku[r][c]] = true;
		}
		return true;
	}
}	
