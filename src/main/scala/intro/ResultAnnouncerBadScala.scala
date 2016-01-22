package intro

object ResultAnnouncerBadScala {

  class Result(_player: String, _score: Int) {
    private val player = _player;
    private val score = _score;

    def getPlayer(): String = {
      return player;
    }

    def getScore(): Int = {
      return score;
    }

    override def equals(o: Any): Boolean = {
      if (this == o) return true;
      if ((o == null) || (this.getClass != o.getClass)) return false;

      val result: Result = o.asInstanceOf[Result];

      if (score != result.score) return false;
      return (player == result.player);

    }

    override def hashCode(): Int = {
      var result: Int = player.hashCode();
      result = 31 * result + score;
      return result;
    }
  }




  private def fetchRunnersUp: java.util.List[Result] = {
    val runnersUp: java.util.List[Result] = new java.util.LinkedList[Result]
    runnersUp.add(new Result("Alice", 2999))
    runnersUp.add(new Result("Bob", 2998))
    runnersUp.add(new Result("Frederica", 2000))
    return runnersUp;
  }

  private def congratulateRunnnersUp(): Unit = {
    val sb: StringBuilder = new StringBuilder
    var first: Boolean = true
    import scala.collection.JavaConversions._
    for (result <- fetchRunnersUp) {
      if (!first) sb.append(",")
      first = false
      sb.append(result.getPlayer)
    }
    System.out.println("Commiserations to : " + sb.toString)
  }

  private def fetchWinner(): Result = {
    return new Result("Daniel", 3000);
  }

  private def announceWinner(): Unit = {
    val result: Result = fetchWinner();
    val winner: String = result.getPlayer();
    val score: Int = result.getScore();

    System.out.println("And the winner was " + winner + "\nwith a score of " + score + "\n Congratulations, " + winner + "!");
  }

  def main(args: Array[String]) {
    announceWinner();
    congratulateRunnnersUp();
  }
}