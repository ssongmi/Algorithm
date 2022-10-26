import java.util.Collections;
import java.util.ArrayList;
class 여행경로 {
    static ArrayList<String> res = new ArrayList<>();
    static boolean[] v;
    public String[] solution(String[][] tickets) {
        v = new boolean[tickets.length + 1];

        dfs("ICN", tickets, "ICN ", 1);
        Collections.sort(res);
        return res.get(0).split(" ");

    }
    static public void dfs(String from, String[][] tickets, String ans, int idx) {
        if(idx == tickets.length + 1) {
            res.add(ans);
        }
        for(int i = 0, len = tickets.length; i < len; i++){
            if(!v[i] && from.equals(tickets[i][0])) {
                v[i] = true;
                dfs(tickets[i][1], tickets, ans + tickets[i][1] + " ", idx + 1);
                v[i] = false;
            }
        }
    }
}