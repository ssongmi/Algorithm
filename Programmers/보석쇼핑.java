import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        Queue<String> q = new LinkedList<>();
        int dist = Integer.MAX_VALUE;
        int start = 0, idx = 0;
        for(int i = 0, len = gems.length; i < len; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            q.offer(gems[i]);

            while(map.get(q.peek()) > 1) {
                map.put(q.peek(), map.get(q.poll()) - 1);
                idx++;
            }

            if(map.size() == gemTypes.size() && dist > (i - idx)) {
                dist = i - idx;
                start = idx + 1;
            }
        }

        return new int[]{start, start + dist };
    }
}