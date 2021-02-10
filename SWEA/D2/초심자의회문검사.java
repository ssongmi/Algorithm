import java.util.Scanner;

public class 초심자의회문검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int flag = 1;
		
		for(int tc = 1; tc <= T; tc++) {
			flag = 1;
			String str = sc.nextLine();
			String str2 = str.substring(str.length()%2 == 0 ? str.length()/2 : str.length()/2+1, str.length());
			String str3 = str.substring(0, str.length()/2);
			
			for(int i = 0; i < str2.length(); i++) {
				if(str2.charAt(i) != str3.charAt(str3.length()-1-i)) {
					flag = 0;
					break;
				}
			}
			System.out.println("#" + tc + " " + flag);
			
			
		}
	}
	

}
