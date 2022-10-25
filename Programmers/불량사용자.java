import java.util.Set;
import java.util.HashSet;
class 불량사용자핑 {
    static int answer = 0;
    static String[] user;
    static String[] banned;
    static Set<Set<String>> set;
    public int solution(String[] user_id, String[] banned_id) {
        user = user_id;
        banned = banned_id;
        set = new HashSet<>();

        dfs(0, new HashSet<String>());

        return set.size();
    }

    static public void dfs(int bannedIdx, Set<String> strSet) {

        if(bannedIdx == banned.length) {

            set.add(strSet);
            return;
        }

        for(int i = 0, len = user.length; i < len; i++ ) {
            if(!strSet.contains(user[i]) && isError(user[i], banned[bannedIdx])) {
                strSet.add(user[i]);
                dfs(bannedIdx+1, new HashSet<String>(strSet));
                strSet.remove(user[i]);
            }
        }


    }
    static public boolean isError (String cur, String target) {
        if(cur.length() != target.length()) {
            return false;
        }

        for(int i = 0, len = target.length(); i < len; i++) {
            if(target.charAt(i) == '*'){
                continue;
            }

            if(target.charAt(i) != cur.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}