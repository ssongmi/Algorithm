import java.util.Arrays;

class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int bIdx = B.length-1;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = A.length - 1; i >=0; i--) {
            if(A[i] < B[bIdx]) {
                answer++;
                bIdx--;
            }
        }

        return answer;
    }
}