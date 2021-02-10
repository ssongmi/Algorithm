import java.util.Scanner;

public class 간단한압축풀기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int idx = 0;
			String[] s = new String[N];
			int total = 0;
			int[] num = new int[N];
			for(int i = 0; i < N; i++) {
				s[i] = sc.next();
				num[i] = sc.nextInt();
				total += num[i];
			}
			String [] arr = new String[total];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < num[i]; j++) {
					arr[idx] = s[i];
					idx++;
				}
			}
			System.out.println("#" +tc);
			for(int i = 0; i < idx; i++){
				if(i != 0 && i%10 == 0) {
					System.out.println();
				}
				System.out.print(arr[i]);
			}
		}
	}
}
