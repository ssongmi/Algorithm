import java.util.Arrays;

class 가장먼노드 {
    static class Node {
        int n1, n2;

        public Node(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        n++;
        boolean[][] map = new boolean[n][n];

        for(int[] e : edge) {
            map[e[0]][e[1]] = true;
            map[e[1]][e[0]] = true;
        }

        int[] dist = new int[n];
        boolean[] v = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for(int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int cur = 0;

            for(int j = 1; j < n; j++) {
                if(!v[j] && min > dist[j]) {
                    min = dist[j];
                    cur = j;
                }
            }

            v[cur] = true;

            for(int j = 1; j < n; j++) {
                if(!v[j] && map[cur][j]  && dist[j] > min + 1) {
                    dist[j] = min + 1;
                }
            }
        }

        Arrays.sort(dist);
        int min = Integer.MAX_VALUE;
        for(int i = n-2; i >= 0; i--) {
            if(min > dist[i]) {
                min = dist[i];
                break;
            }
        }
        for(int num: dist) {
            if(min == num) {
                answer++;
            }
        }
        return answer;
    }
}