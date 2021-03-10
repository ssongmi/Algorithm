import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수묶기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 숫자의 개수를 입력받고
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		// 숫자 개수만큼 숫자들을 입력받고
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 정렬시켜서
		Arrays.sort(arr);
		int idx = 0;
		if(arr[0] > 0) idx = 0;
		else if(arr[N-1] <= 0) idx = N;
		else {
			// 몇번째 인덱스부터 양수가 시작되는지를 찾음
			for(int i = 0; i < N; i++ ) {
				if(arr[i] > 0) {
					idx = i;
					System.out.println("dd");
					break;
				}
			}			
		}

		// 음수 양수가 나눠지는 기점부터 큰수를 묶기 시작함
		int[] negative = Arrays.copyOfRange(arr, 0, idx);
		int[] positive = Arrays.copyOfRange(arr, idx, N);
//		System.out.println("idx = " + idx);
//		System.out.println("negative"+Arrays.toString(negative));
//		System.out.println("positive"+Arrays.toString(positive));
		int total = 0;
		for(int i = 0, size = negative.length; i < size; i+=2) {
			if(i+1 < size) {
				total += negative[i]*negative[i+1];				
			}else {
				total += negative[i];
			}
		}
		int index = positive.length-1;
		while(index >= 0) {
//			System.out.println("arr = " + arr[index]);
			if(index-1 < 0 || positive[index] == 1 || (index-1 >= 0 && positive[index-1] == 1)) {
				total += positive[index];
				index--;
//				System.out.println(total);
			}else if(index-1 >= 0 && positive[index-1] != 1){
				total += positive[index] * positive[index-1];
				index -= 2;
			}
		}
		System.out.println(total);
		//-1 -2 -3 0 1 2 3
		
	}
}
