import scala.io.Source

//https://mkaz.github.io/2011/05/31/10-scala-one-liners-to-impress-your-friends/

/////////////////////////////
(1 to 10).map { n: Int =>
  n * 2
}.toList









/////////////////////////////
(1 to 1000).sum

////////////////////////////
(1 to 1000).foldLeft(1)((x:Int,y:Int) => x*y)



////////////////////////////////////






val wordList = List("scala", "akka", "play framework", "sbt", "typesafe")

val tweet = "This is an example tweet talking about scala and sbt."
wordList.exists(s => tweet.contains(s))

///////////////////////////////////////////////////////////
val states = Map(
"AZ" -> "Arizona",
"FL" -> "Florida"
)

states("AZ")

//states.getOrElse("CA", throw new IllegalArgumentException("No such state"))

//Options
val maybeState = states.get("FL")

val maybeUpperState = maybeState.map(_.toUpperCase)



 // .par.map( case (abbr, _) => println(abbr) )



def todoThisNeedsImplementing(a: String, b: String) = ???

case class StateCode(code: String)
case class StateName(name: String)
case class State(stateCode:StateCode, stateName: StateName)

val allStates = Source.fromFile("c:\\temp\\states.txt")
.getLines
.map{ ln =>
    val Array(stateName, _, code, _) = ln.split("\t")
    StateCode(code) -> State(StateCode(code), StateName(stateName))
  }.toMap


allStates(StateCode("FL"))




//////////////////////

val (passed, failed) = List(49, 58, 76, 82, 88, 90) partition ( _ > 60 )

(1 to 4).map { i =>
  "Happy Birthday " + (if (i == 3) "dear NAME" else "to You") }.foreach { println }
  implicit class PipedObject[T](value:T) {
    def |>[R] (f : T => R) = f(this.value)
  }
//val results = scala.xml.XML.load("http://feeds.bbci.co.uk/news/uk/rss.xml?edition=uk")

def primesUpTo(n:Int) = (2 to n) |> (r => r.foldLeft(r.toSet)((ps, x) => if (ps(x)) ps -- (x * x to n by x) else ps))
primesUpTo(14).toList
  val hmm =
    <html>
      <head>
        <title>Hello XHTML world</title>
      </head>
      <body>
        <h1>Hello world</h1>
        <p><a href="scala-lang.org">Scala</a> talks XHTML</p>
      </body>
    </html>
  println(hmm.toString)
