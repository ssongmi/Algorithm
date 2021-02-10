import java.util.Scanner;

public class 중간평균값구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc <= T; tc++) {
			int[] arr = new int[10];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt(); 
				if(arr[i] > max) {
					max = arr[i];
				}
				if(arr[i] < min) {
					min = arr[i];
				}
				sum += arr[i]; 
			}
			System.out.println(max + ",  " + min);
			sum -= (min + max);
			System.out.println("#" + tc + " " + String.format("%.0f",sum/8.0));

		}
	}

}
