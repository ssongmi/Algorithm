import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 참외밭 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int N = Integer.parseInt(br.readLine());
		int dir = 0, sD = 0;
		int[] lenX = new int[3];
		int[] lenY = new int[3];
		int[] arr = new int[5];
		int mX = 0, mY = 0;
		int inSize = 0;
		int outSize = 0;
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			if(i==0)sD = dir;
			arr[dir]++;
			if(i%2==0)lenX[i/2] = Integer.parseInt(st.nextToken());
			if(i%2==1)lenY[(i-1)/2] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < 3; i++) {
			mX = lenX[i] > lenX[mX] ? i : mX;
			mY = lenY[i] > lenY[mY] ? i : mY;
		}

		outSize = lenX[mX] * lenY[mY];

		if(arr[2]+arr[4] == 2 || arr[3]+arr[1] == 2) {
			if(sD > 2 ) {
				inSize = (lenX[(mX+2)%3]) * (lenY[(mY+1)%3]);
			}else {				
				inSize = (lenY[(mY+2)%3]) * (lenX[(mX+1)%3]);
			}
		}else if(arr[1]+arr[4] == 2 || arr[2]+arr[3] == 2) {
			if(sD > 2 ) {
				inSize = (lenX[(mX+1)%3]) * (lenY[(mY+2)%3]);
			}else {				
				inSize = (lenY[(mY+1)%3]) * (lenX[(mX+2)%3]);
			}
		}
		int ans = (outSize - inSize) * N;
		System.out.println(ans);
	
	}
}
