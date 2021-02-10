import java.util.Arrays;
import java.util.Scanner;

public class 수도쿠검증 {
	static int[] used = new int[10];
	static int flag = 1;
	static int[][] intArray = new int[9][9];
	
	static int rowCon() {
		for(int i = 0; i < intArray[0].length; i++) {
			arrReset(used);
			for(int j = 0; j < 9; j++ ) {
				used[intArray[i][j]] = 1;
			}
			flag = isUsed(used);
			if(flag == 0) break;
		}
		return flag;
	}
	
	static int colCon() {
		for(int i = 0; i < intArray[0].length; i++) {
			arrReset(used);
			for(int j = 0; j < 9; j++ ) {
				used[intArray[j][i]] = 1;
			}
			flag = isUsed(used);
			if(flag == 0) break;
		}
		return flag;
	}
	
	static int blockCon() {
			
		for(int i = 0; i < 9; i = i+3) {
			arrReset(used);
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					used[intArray[j+i][k+i]] = 1;
				}
			}
			flag = isUsed(used);
			if(flag == 0) break;
		}
		return flag;
	}
	
	static void arrReset(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}
	
	static int isUsed(int[] arr) {
		int used = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != 1) { used = 0; }
			
		}
		return used;
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <= T; i++) {
			
			for(int j = 0; j < 9; j++) {
				for(int k = 0; k < 9; k++) {
					intArray[j][k] = sc.nextInt();
				}
			}

			
			if( rowCon() == 0 || colCon() == 0 || blockCon() == 0) {
				System.out.println("#" + i + " 0");
			}else {
				System.out.println("#" + i + " 1");
			}
		}
	}
}
