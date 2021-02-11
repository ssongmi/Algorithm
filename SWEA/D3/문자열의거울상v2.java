import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class 문자열의거울상v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        int T = Integer.parseInt(br.readLine());
        // 원래 글자
        char[] type = {'b','d','p','q'};
        // 거울에 비쳤을 때
        char[] mirrorType = {'d','b','q','p'};
         
        for(int tc = 1; tc <= T; tc++) {
            // 문자열 입력
            String s = br.readLine();
            Stack<Character> str = new Stack<>();
            StringBuilder newStr = new StringBuilder();
             
            // 거울에 비치면 그 순서가 역순이 되기때문에 stack에 넣어줌
            for(int i = 0; i < s.length(); i++) {
                str.push(s.charAt(i));
            }
             
            // stack에서 한 문자씩 빼면서 원래 타입에서 거울에 비친 타입으로 바꿔줌 
            for(int i = 0; i <s.length(); i++) {
                for(int j = 0; j < type.length; j++) {
                    if(str.peek() == type[j]) {
                        newStr.append(mirrorType[j]);
                        str.pop();
                        break;
                    }
                }
            }
            sb.append("#" + tc + " " + newStr  + "\n");
        }
        System.out.println(sb);
    }
     
}