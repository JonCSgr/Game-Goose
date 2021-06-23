import scala.collection.mutable.ArrayBuffer

class Player(val player: String) {

 var index: Int = 0;

def getName(): String ={
 return player
}

 def updateIndex(updateIndex: Int):Unit ={
   index = index + updateIndex;
 }

  def setIndex(indexUpdate: Int): Unit ={
    index = indexUpdate
  }

  def setBridge(): Unit ={
    index = 12;
  }

 def printIndex(): Unit ={
   println(index)
 }

  def getIndex(): Int ={
    return index;
  }
}
