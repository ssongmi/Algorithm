import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 방배정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		// 학생수
		int N = Integer.parseInt(st.nextToken());
		
		// 한 방에 들어갈 수 있는 최대 인원
		int K = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[7][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());			
			students[grade][gender]++;
		}
		int sum = 0;

		for(int i = 1; i < 7; i++) {
			
			sum += students[i][0]/K + (students[i][0]%K == 0 ? 0 : 1);
			sum += students[i][1]/K + (students[i][1]%K == 0 ? 0 : 1);
		}
		System.out.println(sum);
	}
}
