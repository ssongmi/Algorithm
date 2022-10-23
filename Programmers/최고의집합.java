import java.util.Arrays;
class 최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer = {};

        if(n > s) {
            return new int[] { -1 };
        }

        answer = new int[n];

        for(int i = 0; i < n; i++) {
            answer[i] = s/n;
        }

        for(int i = 0, len = s%n; i < len; i++) {
            answer[i]++;
        }

        Arrays.sort(answer);

        return answer;
    }
}