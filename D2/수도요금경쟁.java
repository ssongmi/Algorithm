import java.util.Scanner;

public class 수도요금경쟁 {
	static int feeA(int P, int W) {
		return P*W;
	}
	
	static int feeB(int Q, int R, int S, int W) {
		if(W <= R) {
			return Q;
		}else {
			return Q + S*(W - R);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		int P,Q,R,S,W;
		int A, B;
		
		for(int i = 1; i <= T; i++) {
			P = sc.nextInt();
			Q = sc.nextInt();
			R = sc.nextInt();
			S = sc.nextInt();
			W = sc.nextInt();
			
			A = feeA(P, W);
			B = feeB(Q, R, S, W);
			
			System.out.println("#" + i + " " + ((A > B) ? B : A));
			
		}
	}
}
