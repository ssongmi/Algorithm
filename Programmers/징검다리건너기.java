import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.stream.*;

class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int stone : stones) {
            if(stone > max) max = stone;
            if(stone < min) min = stone;
        }

        while(min <= max) {
            int mid = (min + max) / 2;

            if(isPossible(mid, stones, k)) {
                min = mid + 1;
                if(mid > ans) {
                    ans = mid;
                }
            } else {
                max = mid - 1;
            }
        }

        return ans;
    }
    static public boolean isPossible (int mid, int[] stones, int k) {
        int cnt = 0;

        for(int stone : stones) {
            if(stone - mid < 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            if(cnt == k){
                return false;
            }
        }
        return true;
    }
}