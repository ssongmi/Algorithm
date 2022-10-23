import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int w : works) {
            pq.offer(w);
        }

        while(n > 0) {
            pq.offer(pq.poll()-1);
            n--;

            if(pq.peek() == 0) break;
        }

        for(int w : pq) {
            answer += Math.pow(w, 2);
        }

        if(n != 0)  return 0;

        return answer;
    }
}