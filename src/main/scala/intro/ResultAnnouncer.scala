package intro

object ResultAnnouncer extends App {

  case class Result(player: String, score: Int)

  def fetchWinner = Result("Daniel", 3000)

  def fetchRunnersUp =
    List(
      Result("Alice", 2999),
      Result("Bob", 2998),
      Result("Frederica", 2000))

  def announceWinner() = {
    val Result(winner, score) = fetchWinner
    println(
    s"""And the winner was $winner
        |with a score of $score
        |Congratulations, $winner!"""
      .stripMargin)
  }

  def congratulateRunnersUp() = {
    println(s"Commiserations to ${fetchRunnersUp.map(_.player).mkString(",")}")
  }

  announceWinner()
  congratulateRunnersUp()
}