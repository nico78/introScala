package intro


object ResultAnnouncerBadScala {

   class Result(var winner: String, var score: Int) {

    def getWinner(): String = {
      return winner;
    }

    def getScore(): Int = {
      return score;
    }

    def canEqual(other: Any): Boolean = other.isInstanceOf[Result]

    override def equals(o: Any): Boolean = {
      if (this == o) return true;
      if ((o == null) || (this.getClass ne o.getClass)) return false;

      val result: Result = o.asInstanceOf[Result];

      if (score != result.score) return false;
      return (winner == result.winner);

    }
    
    override def hashCode(): Int = {
      var result: Int = winner.hashCode();
      result = 31 * result + score;
      return result;
    }
  }

  def fetchResult(): Result = {
    return new Result("Daniel", 3000)
  }

  def announceWinner(): Unit =  {
    val result: Result = fetchResult();
    val winner: String = result.getWinner();
    val score: Int = result.getScore();

    System.out.println("And the winner was " + winner + "\nwith a score of " + score + "\n Congratulations, " + winner + "!")
  }

  def main(args: Array[String]) {
    announceWinner
  }
}