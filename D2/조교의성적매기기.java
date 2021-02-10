import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 조교의성적매기기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		int N, K; // N�� �� �л���, K�� �ñ��� �л� ��ȣ
		double[][] scores;
		double[] order;
		int[] grades;
		int base = 1;
		double s = 0;
		int ans = 0;
		String[] type = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();

			scores = new double[N][3];
			order = new double[N];
			grades = new int[N];
			ans = 0;
			base = 1;
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < 3; i++) {
					scores[j][i] = sc.nextDouble();
				}
			}

			for (int i = 0; i < N; i++) {
				order[i] = scores[i][0] * 0.35 + scores[i][1] * 0.45 + scores[i][2] * 0.2;
				if (i == K - 1) {
					s = order[i];
				}
			}

			Arrays.sort(order);
			grades[N - 1] = base;
			System.out.println(Arrays.toString(order));
			for (int i = N - 2; i >= 0; i--) {
				if (Double.compare(order[i], order[i + 1]) != 0) {
					base++;
				}
				grades[i] = base;
			}
			for (int i = 0; i < N; i++) {
				grades[i] = (grades[i] - 1) / (N / 10);
			}
			System.out.println(Arrays.toString(grades));
			System.out.println(s);
			for (int i = 0; i < N; i++) {
				if (Double.compare(s, order[i]) == 0) {
					ans = grades[i];
				}
			}
			System.out.println("#" + tc + " " + type[ans]);

		}

	}

}
