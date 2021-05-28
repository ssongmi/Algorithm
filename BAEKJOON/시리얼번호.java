import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 시리얼번호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static class SerialNumber implements Comparable<SerialNumber> {
		String number;

		public SerialNumber(String number) {
			super();
			this.number = number;
		}

		@Override
		public int compareTo(SerialNumber o) {
			int len1 = this.number.length();
			int len2 = o.number.length();

			if (len1 != len2)
				return len1 - len2;

			int val1 = getSum(len1, this.number);
			int val2 = getSum(len2, o.number);

			if (val1 != val2)
				return val1 - val2;

			String[] arr = new String[2];
			arr[0] = this.number;
			arr[1] = o.number;
			Arrays.sort(arr);
			if(arr[0] == this.number) return -1;
			return 1;
		}

	}

	private static int getSum(int len, String str) {
		int res = 0;
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if (ch > '0' && ch <= '9') {
				res += ch - '0';
			}
		}

		return res;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());

		SerialNumber[] arr = new SerialNumber[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new SerialNumber(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(SerialNumber sn : arr) sb.append(sn.number).append("\n");
		System.out.println(sb);
	}

}
