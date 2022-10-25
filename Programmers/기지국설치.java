class 기지국설치자 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 1;
        int cnt = 0;
        for(int st : stations) {
            int end = st - w;
            // System.out.println("start = " + start + ", end = " + end);
            if(end <= start) {
                start = st + w +1;
                continue;
            }
            cnt += (end - start) / (2*w + 1);
            if((end - start) % (2*w + 1) != 0) {
                cnt++;
            }
            // System.out.println("cnt = " + cnt);
            start = st + w + 1;
        }
        // System.out.println("start = " + start);
        if( start <= n) {
            cnt += (n - start + 1) / (2*w+1);
            if((n - start + 1) % (2*w+1) != 0) {
                cnt++;
            }
        }

        return cnt;
    }
}