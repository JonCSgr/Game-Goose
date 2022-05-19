import scala.collection.mutable.ArrayBuffer

object main {
  def main(args: Array[String]): Unit = {

    val gamee = new game()

      while(true) {
      val playerName = scala.io.StdIn.readLine()
      if(playerName.equals("Start")){
          while(true){
            val move = scala.io.StdIn.readLine()
            val moveSplit = move.split(" ")
            if(moveSplit(0).equals("move")){
               // println(moveSplit(0)+moveSplit(1)+moveSplit(2)+moveSplit(3))
                if(moveSplit.length == 4) {
                  val firstValue = moveSplit(2).replaceAll("\\p{Sc}|,", "").toInt
                  val secondValue = moveSplit(3).toInt
                  val totalMove = firstValue + secondValue
                  //  println(totalMove)
                  print(moveSplit(1) + " rolls " + moveSplit(2) + " " + moveSplit(3) + ". ")
                  gamee.movePlayer(moveSplit(1), totalMove)
                }else if(moveSplit.length == 2){
                  gamee.movePlayerAuto(moveSplit(1))
                }
            }
          //  gamee.printPlayersIndex()
          }


      }
      val result = playerName.split(" ")

      if (result.length == 3) {
        if (result(0).equals("add") && result(1).equals("player")) {
        //println(result(2))
        val newPlayer = new Player(result(2))
        gamee.addPlayer(newPlayer)
      }
      }
      println()
    }







  }



}
