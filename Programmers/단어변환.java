import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }
    static boolean isPossible(String cur, String target) {
        int cnt = 0;
        for(int i = 0, len = cur.length(); i < len; i++) {
            if(cur.charAt(i) != target.charAt(i)) {
                if(++cnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = words.length;

        boolean[] v = new boolean[n];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.next.equals(target)) {
                answer = cur.edge;
                break;
            }

            for(int i = 0; i < n; i++) {
                if(!v[i] && isPossible(cur.next, words[i])) {
                    v[i] = true;
                    q.offer(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return answer;


    }
}