import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

 class game {

  var playersList = new ArrayBuffer[Player]()
  var playersSpace: Int = 0

  def addPlayer(newPlayer:Player): Unit =
  {
    if(!playerExist(newPlayer)) {
      playersList += newPlayer
      printPlayers()
    }else{
      println(newPlayer.getName()+": already existing player")
    }
  }

   def movePlayer(name:String,dice:Int): Unit ={
     var curr = 0;
     var goBack = 0
      for(i <- playersList){
        if(i.getName().equals(name)){
             goBack = i.getIndex()
            if(i.getIndex == 0){
              print(name+" moves from Start to ")
            }else{
              print(name+" moves from "+ i.getIndex()+ " "+ "to ")
            }
            i.updateIndex(dice)
            if(i.getIndex() > 63){
            val difference = i.getIndex() - 63
            i.setIndex(63 - difference)
            println("63. "+i.getName()+" bounces! "+i.getName()+" returns to "+i.getIndex())
            return
          }

          if(i.getIndex() == 63){
            println(( i.getIndex() + ". "+i.getName() +" Wins!!" ))
            System.exit(0)
            return
          }else if(i.getIndex() == 6){
            i.setBridge()
            println("The bridge. "+i.getName()+" jumps to "+i.getIndex())
          }else if(i.getIndex() == 5 || i.getIndex() == 9 || i.getIndex() == 14 || i.getIndex() == 18 || i.getIndex() == 23 || i.getIndex() == 27){
            var y = true
            while(i.getIndex() == 5 || i.getIndex() == 9 || i.getIndex() == 14 || i.getIndex() == 18 || i.getIndex() == 23 || i.getIndex() == 27) {
              if(y) {
                print(i.getIndex() + ", The goose. " + name + " moves again and goes to ")
                i.updateIndex(dice)
                print(i.getIndex())
                y = false
              }else{
                print(", The goose. " + name + " moves again and goes to ")
                i.updateIndex(dice)
                print(i.getIndex())
              }
            }
            println()
          }else{
            println(i.getIndex())
          }
          curr = i.getIndex()
        }
       prank(curr,goBack,name)
      }
   }

   def prank(curr:Int,goBack:Int,name:String): Unit ={
     if(goBack == 0 || curr == 0)
       return
     for(i <- playersList) {
      if(i.getIndex() == curr && i.getName()!=name){
         println("On "+curr+" there is "+i.getName()+", who returns to " + goBack)
         i.setIndex(goBack)
       }

     }
   }



   def movePlayerAuto(name:String): Unit ={
     var curr = 0;
     var goBack = 0
     val dice1 = rollDice()
     val dice2 = rollDice()
     val dice = dice1 + dice2
     for(i <- playersList){
       if(i.getName().equals(name)){
         goBack = i.getIndex()
         print(name+" rolls "+dice1+", "+dice2+". ")
         if(i.getIndex == 0){
           print(name+" moves from Start to ")
         }else{
           print(name+" moves from "+ i.getIndex()+ " "+ "to ")
         }

         i.updateIndex(dice)
         if(i.getIndex() > 63){
           val difference = i.getIndex() - 63
           i.setIndex(63 - difference)
           println("63. "+i.getName()+" bounces! "+i.getName()+" returns to "+i.getIndex())
           return
         }

         if(i.getIndex() == 63){
           println(( i.getIndex() + ". "+i.getName() +" Wins!!" ))
           System.exit(0)
         }else if(i.getIndex() == 6) {
           i.setBridge()
           println("The bridge. "+i.getName()+" jumps to "+i.getIndex())
         }else if(i.getIndex() == 5 || i.getIndex() == 9 || i.getIndex() == 14 || i.getIndex() == 18 || i.getIndex() == 23 || i.getIndex() == 27){
           var y = true
           while(i.getIndex() == 5 || i.getIndex() == 9 || i.getIndex() == 14 || i.getIndex() == 18 || i.getIndex() == 23 || i.getIndex() == 27) {
             if(y) {
               print(i.getIndex() + ", The goose. " + name + " moves again and goes to ")
               i.updateIndex(dice)
               print(i.getIndex())
               y = false
             }else{
               print(", The goose. " + name + " moves again and goes to ")
               i.updateIndex(dice)
               print(i.getIndex())
             }
           }
           println()
         }else{
           println(i.getIndex())
         }
         curr = i.getIndex()
       }
       prank(curr,goBack,name)
     }
   }


   def rollDice(): Int ={
     val r = new scala.util.Random
     val r1 = 1 + r.nextInt(( 6 - 1) + 1)
      return r1
   }

   def printPlayersIndex(): Unit ={
     for(i <- playersList){
         i.printIndex()
       }
   }

   def printPlayers(): Unit ={
     var i = 0;
     print("players: ")

     breakable {
       while (i < playersList.length) {
         print(playersList(i).getName)

         if (i == playersList.length - 1) {
           break
         }

         if (playersList.length > 1)
           print(',')

         i = i + 1;
       }
     }
   }


   def playerExist(playerName:Player): Boolean ={
     var i = 0;
     while(i < playersList.length){
       if(playersList(i).getName().equals(playerName.getName())) {
           return true
       }
       i = i + 1;
     }
      false
   }

}
