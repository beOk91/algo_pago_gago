package kjy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 베스트앨범_42579 {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 정리
        Map<String, List<Music>> musicDictionary = IntStream.range(0, genres.length)
            .mapToObj(i -> new Music(genres[i], i, plays[i]))
            .collect(Collectors.groupingBy(Music::getGenre));

        return musicDictionary.entrySet().stream()
            // 많이 재생된 장르 순 정렬
            .sorted((x, y) -> getTotalPlayed(y.getValue()) - getTotalPlayed(x.getValue()))
            .flatMap(x -> x.getValue().stream()
                     .sorted()  // 1. 많이 재생된 노래, 2. 고유번호 순
                     .limit(2)) // 최대 두 곡
            .mapToInt(x -> x.id).toArray();
    }

    private int getTotalPlayed(List<Music> musics) {
        return musics.stream()
            .mapToInt(x -> x.played)
            .sum();
    }

    static class Music implements Comparable<Music> {
        private final String genre; 
        private final int id;
        private final int played;

        public Music(String genre, int id, int played) {
            this.genre = genre;
            this.id = id;
            this.played = played;
        }

        public String getGenre() {
            return this.genre;
        }

        @Override
        public int compareTo(Music other) {
            return this.played == other.played
                ? this.id - other.id
                : other.played - this.played;
        }
    }
}
