package intro;

public class ResultAnnouncerJav {

    private static class Result {
        private final String winner;
        private final int score;

        public Result(String winner, int score) {
            this.winner = winner;
            this.score = score;
        }

        public String getWinner() {
            return winner;
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
            return winner.equals(result.winner);
        }

        @Override
        public int hashCode() {
            int result = winner.hashCode();
            result = 31 * result + score;
            return result;
        }
    }

    public Result fetchResult(){
        return new Result("Daniel", 3000);
    }

    public void announceWinner() {
        Result result = fetchResult();
        String winner = result.getWinner();
        int score = result.getScore();
        System.out.println("And the winner was " + winner + "\nwith a score of " + score + "\n Congratulations, " + winner + "!" );
    }

    public static void main(String[] args) {
        final ResultAnnouncerJav resultAnnouncer = new ResultAnnouncerJav();
        resultAnnouncer.announceWinner();
    }
}
