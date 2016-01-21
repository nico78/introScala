package intro;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ResultAnnouncerJav {

    private static class Result {
        private final String player;
        private final int score;

        public Result(String player, int score) {
            this.player = player;
            this.score = score;
        }

        public String getPlayer() {
            return player;
        }

        public int getScore() {
            return score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Result result = (Result) o;

            if (score != result.score) return false;
            return player.equals(result.player);
        }

        @Override
        public int hashCode() {
            int result = player.hashCode();
            result = 31 * result + score;
            return result;
        }
    }

    private static Result fetchWinner() {
        return new Result("Daniel", 3000);
    }

    private static List<Result> fetchRunnersUp() {
        List<Result> runnersUp = new LinkedList<Result>();
        runnersUp.add(new Result("Alice", 2999));
        runnersUp.add(new Result("Bob", 2998));
        runnersUp.add(new Result("Frederica", 2000));
        return runnersUp;
    }

    private static void announceWinner() {
        Result result = fetchWinner();
        String winner = result.getPlayer();
        int score = result.getScore();
        System.out.println("And the player was " + winner + "\nwith a score of " + score + "\n Congratulations, " + winner + "!");
    }


    private static void congratulateRunnnersUp() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Result result : fetchRunnersUp()) {
            if (!first)
                sb.append(",");
            first = false;
            sb.append(result.getPlayer());
        }
        //  Joiner.on(",").join(fetchRunnersUp());
        System.out.println("Commiserations to :" + sb.toString());
    }

    public static void main(String[] args) {
        announceWinner();
        congratulateRunnnersUp();
    }
}
