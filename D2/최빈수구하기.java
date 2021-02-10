import java.util.Arrays;
import java.util.Scanner;

public class 최빈수구하기 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = 0; // �뀒�뒪�듃 耳��씠�뒪 �닽�옄
		
		int score = 0;
		int[] scores = new int[1000];
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int[] modes = new int[101];
			int mode = 0;
			
			num = sc.nextInt();
			for (int j = 0; j < 1000; j++) {
				scores[j] = sc.nextInt();
				modes[scores[j]]++;
			}
			for(int k = 0; k < 101; k++) {
				if(modes[k] >= mode) {
					mode = modes[k];
					score = k;
				}
			}
			System.out.println("#" + i + " " + score);
		}
	}

}
