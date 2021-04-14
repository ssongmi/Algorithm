import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int L, C;
	static char[] str;
	static boolean[] v;
	static char[] ans;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		v = new boolean[C];
		str = new char[C];
		ans = new char[L];
		// 입력받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			str[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(str);
		comb(0,0);
		System.out.println(sb);
		// 길이 L의 조합을 해보고
		// 최소 한개의 모음과 최소 두개의 자음이 들어있는지 확인
	}
	static int count = 0;
	static char[] chk = {'a', 'e', 'i', 'o', 'u'};
	private static void comb(int idx, int cnt) {
		if(cnt == L) {
			// 여기서 최소 한개의 모음과 최소 두개의 자음이 있는지 확인
//			System.out.println(Arrays.toString(ans));
			if(check(ans)) {
				for(int i = 0; i < L; i++) sb.append(ans[i]);
				sb.append("\n");
			}
			return;
		}
		for(int i = idx; i < C; i++) {
			ans[cnt] = str[i];
			comb(i+1, cnt+1);
		}
	}
	private static boolean check(char[] ans) {
		int count1 = 0; // 모음 카운터
		int count2 = 0; // 자음 카운터
		for(int i = 0; i < L; i++) {
			boolean flag = false;
			for(int j = 0; j < 5; j++) {
				if(ans[i] == chk[j]) {
					count1++;
					flag = true;
					break;
				}
			}
			if(!flag)count2++;
		}
		if(count1 > 0 && count2 > 1) return true;
		return false;
	}
}
