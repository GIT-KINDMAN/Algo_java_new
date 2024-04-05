import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
//         Map<String, ArrayList<Integer>> map = new HashMap<>();
        
//         for (int i=0; i<plays.length; i++) {
//             ArrayList<Integer> list;
//             if (!map.containsKey(genres[i])) {
//                 list = new ArrayList<>();
//             } else {
//                 list = map.get(genres[i]);
//             }
//             list.add(plays[i]);
//             Collections.sort(list, Comparator.reverseOrder());
//             map.put(genres[i], list);
//         }

        
//         HashMap<String, HashMap<Integer, ArrayList<Integer>>> map = new HashMap<>();
        
//         for (int i=0; i<plays.length; i++) {
//             HashMap<Integer, ArrayList<Integer>> val_map;
//             ArrayList<Integer> list;
//             if (!map.containsKey(genres[i])) {
//                 val_map = new HashMap<>();
//                 list = new ArrayList<>();
//             } else {
//                 val_map = map.get(genres[i]);
//                 list = val_map.get(i);
//             }
//             list.add(plays[i]);
            
//             Collections.sort(list, Comparator.reverseOrder());
//             val_map.put(i, list);
//             map.put(genres[i], val_map);
//         }
        
//         for (String item : map.keySet()) {
//             System.out.print(item + ": " + map.get(item) + "\n");
//         }

//      public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> genres_map = new HashMap<>();
        HashMap<String, ArrayList<Song>> songs_map = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            genres_map.put(genres[i], genres_map.getOrDefault(genres[i], 0) + plays[i]);
            
            // ArrayList<Integer> list;
            // if(!songs_map.containsKey(genres[i])) {
            //     list = new ArrayList<>();
            // } else {
            //     list = songs_map.get(genres[i]);
            // }
            
            ArrayList<Song> list = songs_map.get(genres[i]);
            if(list == null) {
                list = new ArrayList<>();
            }
            list.add(new Song(i, plays[i]));
            // Collections.sort(genres_map, (g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));
        
            songs_map.put(genres[i], list);
        }

        for (String item : genres_map.keySet()) {
            ArrayList<Song> songs = songs_map.get(item);
            Collections.sort(songs, (s1, s2) -> s2.plays - s1.plays);
        }
        
        // ArrayList<String> gl = new ArrayList<>(genres_map.keySet());
        // Collections.sort(gl, (g1, g2) -> genres_map.get(g2) - genres_map.get(g1));
        
//         String[] g = new String[2];
//         g[0] = gl.get(0);
//         g[1] = gl.get(1);
        
//         for (int i=0; i<2; i++) {
//             ArrayList<Song> songs = songs_map.get(g[i]);
//             Collections.sort(songs, (s1, s2) -> s2.plays - s1.plays);
//             answer[i*2] = songs.get(0).index;
//             answer[i*2+1] = songs.get(1).index;
//         }

        ArrayList<String> gl = new ArrayList<>(genres_map.keySet());
        Collections.sort(gl, (g1, g2) -> genres_map.get(g2) - genres_map.get(g1));
        
        ArrayList<Integer> ans_list = new ArrayList<>();
        
        for (String genre : gl) {
            ArrayList<Song> songs = songs_map.get(genre);
            Collections.sort(songs, (s1, s2) -> s2.plays - s1.plays);
            
            // 각 장르에서 최대 2곡까지만 answerList에 추가 (2보다 작은 경우 고려)
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                ans_list.add(songs.get(i).index);
            }
        }
        
        int[] answer = new int[ans_list.size()];
        
        for (int i=0; i<answer.length; i++) {
            answer[i] = ans_list.get(i);
        }
        
        // for (String item : songs_map.keySet()) {
            // ArrayList<Song> songs = songs_map.get(item);
            // Collections.sort(songs, (s1, s2) -> s2.plays - s1.plays);
        // }
        
        // for (String item : songs_map.keySet()) {
        //     ArrayList<Song> al = songs_map.get(item);
        //     for (Song item2 : al) {
        //         System.out.print(item + ": " + item2.index + ", " + item2.plays + "\n");    
        //     }
        // }
        
        return answer;
    }
}

class Song {
    int index;
    int plays;
    
    Song (int index, int plays) {
        this.index = index;
        this.plays = plays;
    }
}
    
// } 