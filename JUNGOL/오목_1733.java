package day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 오목_1733 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] board;
	static int curr; // 현재 검사하고 있는 바둑알의 색
	static boolean flag; // 승리 판정이 됐는지
	static int searchRow, searchCol;
	public static void main(String[] args) throws IOException {
		// 19개의 가로줄과 세로줄
		board = new int[19][19];
	
		// 오목판 입력
		for(int r = 0; r < 19; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 19; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 검은 바둑알은 1, 흰 바둑알을 2, 알이 놓이지 않은 자리는 0
		// 배열을 탐색하며 검은 바둑알이나 흰 바둑알이 나오면 승리할 수 있는지 판단
		int r = 0, c = 0;  
		// 승리한 색의 오목 중 가장 왼쪽 바둑알의 행과 열을 기억하기 위해서 열을 우선으로 순회
		out : for(c = 0; c < 19; c++) {
			for(r = 0; r < 19; r++) {
				if(board[r][c] != 0) {
					curr = board[r][c];
					cnt = 0;
					search(r, c);
					if(cnt == 5 ) {
						// 정반대 방향이 존재하지 않거나 존재한다면 현재의 값과 달라야함 
						if(r-dr[dir] < 0 || r - dr[dir] >= 19 || c-dc[dir] < 0 || c-dc[dir] >= 19 || board[r-dr[dir]][c-dc[dir]] != curr) {
							flag = true;
							break out; // 승리한 색을 알아내면 바로 종료							
						}
					}
				}
			}
		}
		
		sb.append(String.format("%d \n", flag ? curr : 0));
		if(flag) sb.append(String.format("%d %d", r+1, c+1));
		System.out.println(sb);
	}
	// 12시 방향부터 시계 방향으로
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int dir = -1; // 현재 진행 방향
	static int cnt = 0; // 연속으로 있는 바둑알 수
	private static void search(int row, int col) {
		cnt++;
		// 첫번째 발견한 바둑알의 경우
		if(cnt == 1) {
			for(int i = 0; i < 8; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if(nr < 0 || nr >= 19 || nc < 0 || nc >= 19 || board[nr][nc] != curr) continue;
				dir = i;
				cnt = 1;
				search(nr, nc);
				if(cnt == 5) return;
			}			
		}else { // 시작하는 바둑알이 아닌 경우
			// 진행했던 방향으로만 확인해야 함
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(nr < 0 || nr >= 19 || nc < 0 || nc >= 19 || board[nr][nc] != curr) return;
			search(nr, nc);
		}
		
	}
}
