import java.util.Scanner;

public class 백만장자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int tc = 1; tc <= T; tc++ ) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int end = N-1;
			long sum = 0;
			for(int i = 0; i < arr.length; i++)
				arr[i] = sc.nextInt();
			long MAX = arr[N-1];
			for(int i = arr.length-1; i >= 0; i-- ) {
				if(arr[i] > MAX || i == 0) {
					for(int j = (i == 0 ? 0 :(i + 1)); j < end; j++) {
						System.out.println(i);
						System.out.println(end);
						sum += (-arr[j] + MAX);
					}
					MAX = arr[i];
					end = i;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
