import scala.annotation.tailrec

object MaxProfit extends App {
  val input = Array(7,1,5,3,6,4)

  def maxProfit(prices: Array[Int]): Int = {
    prices.foldLeft(Int.MinValue, prices.head){
      case((maxPrice, minPrice), currentPrice) => (maxPrice.max(currentPrice - minPrice), minPrice.min(currentPrice))
    }._1
  }

//  def maxProfit(prices: Array[Int]): Int = {
//    def makePair(list: List[Int]): List[(Int, Int)] = {
//      def helper(h: Int, rest: List[Int], acc: List[(Int, Int)]): List[(Int, Int)] = {
//        rest match {
//          case Nil => acc
//          case _ => {
//            val pairs = for(n <- rest) yield (h, n)
//            helper(rest.head, rest.tail, acc ++ pairs)
//          }
//        }
//      }
//      helper(list.head, list.tail, List.empty)
//    }
//    val pairs = makePair(prices.toList).map((pair: (Int, Int)) => pair._2 - pair._1).filter(_ > 0)
//    if(pairs.isEmpty) return 0
//    else pairs.max
//  }


}