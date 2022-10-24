import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

class 베스트앨범 {
    static class Album {
        int num, cnt;
        String genre;

        Album(int num, String genre, int cnt) {
            this.num = num;
            this.cnt = cnt;
            this.genre = genre;
        }

    }
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0, len = plays.length; i < len; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> orderedGenres = new ArrayList<>();
        while(map.size() != 0) {
            int max = -1;
            String maxKey = "";

            for(String key: map.keySet()) {
                int cnt = map.get(key);
                if(cnt > max) {
                    max = cnt;
                    maxKey = key;
                }
            }
            orderedGenres.add(maxKey);
            map.remove(maxKey);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(String g : orderedGenres) {
            ArrayList<Album> list = new ArrayList<>();

            for(int i = 0, len = genres.length; i < len; i++) {
                if(genres[i].equals(g)) {
                    list.add(new Album(i, g, plays[i]));
                }
            }

            Collections.sort(list, (a1, a2) -> a2.cnt - a1.cnt);
            res.add(list.get(0).num);
            if(list.size() > 1) {
                res.add(list.get(1).num);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}

