import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class 냉장고{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static class re implements Comparable<re>{
        int min, max;
 
        public re(int min, int max) {
            super();
            this.min = min;
            this.max = max;
        }
 
        @Override
        public int compareTo(re o) {
        	if(this.max == o.max) return this.min - o.min;
        	else return this.max - o.max;
        }
 
        @Override
        public String toString() {
            return "re [min=" + min + ", max=" + max + "]";
        }
         
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
         
        re[] reArr= new re[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            reArr[i] = new re(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(reArr);
        int cnt = 1;
        int max = reArr[0].max;
        for(int i = 1; i < N; i++) {
            if(reArr[i].min > max) {
            	max = reArr[i].max;
            	cnt++;
            }
        }
        System.out.println(cnt);

         
    }
}