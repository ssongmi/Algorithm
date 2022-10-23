import java.util.*;
class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> ascQ = new PriorityQueue<>();
        PriorityQueue<Integer> descQ = new PriorityQueue<>(Collections.reverseOrder());

        int cnt = 0;
        for(int i = 0, len = operations.length; i < len; i++) {
            String[] op = operations[i].split(" ");

            if(op[0].equals("I")) {
                cnt++;
                int cur = Integer.parseInt(op[1]);
                descQ.offer(cur);
                ascQ.offer(cur);
            } else if(op[0].equals("D") && op[1].equals("1")) {
                descQ.poll();
                cnt = cnt -1 < 0 ? 0 : cnt - 1;

            } else if(op[0].equals("D") && op[1].equals("-1")) {
                ascQ.poll();
                cnt = cnt -1 < 0 ? 0 : cnt -1;
            }

            if(cnt == 0) {
                descQ.clear();
                ascQ.clear();
            }

        }

        if(cnt == 0) {
            return new int[] { 0, 0 };
        }
        return new int[] {descQ.poll(), ascQ.poll()};
    }
}