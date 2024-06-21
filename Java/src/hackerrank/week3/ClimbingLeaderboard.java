package hackerrank.week3;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbingLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> players) {
        List<Integer> positions = new ArrayList<>();
        ranked = ranked.stream()
                .distinct().sorted().collect(Collectors.toCollection(ArrayList::new));
        int index = 0;

        for (int score : players) {
            while (index < ranked.size() && ranked.get(index) <= score) {
                index++;
            }
            positions.add((ranked.size()-index) + 1);
        }

        return positions;
    }

    @Test
    public void sampleTest() {
        List<Integer> ranked = new ArrayList<>();
        ranked.add(100);
        ranked.add(90);
        ranked.add(90);
        ranked.add(80);

        List<Integer> player = new ArrayList<>();
        player.add(70);
        player.add(80);
        player.add(105);

        System.out.println(climbingLeaderboard(ranked, player));

    }
}
