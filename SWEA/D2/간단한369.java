import java.util.Scanner;

public class °£´ÜÇÑ369 {
	static int count = 0;
	
	static int decide(int num) {
		if(num < 10) { 
			if (num%3 == 0) {
				count++;
			} 
			return count;
		}
		int one_place = num % 10;
		if(one_place == 3 || one_place == 6 || one_place == 9  ) { count++; }
		return decide(num/10);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i_count = 0;
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			count = 0;
			i_count = decide(i);
			if(i_count == 0) {
				System.out.print(i + " ");
			}else {
				for(int j = 0; j < i_count; j++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
		}
		
		
	}

}
