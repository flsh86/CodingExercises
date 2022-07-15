import scala.annotation.tailrec

object MergeTwoLists {
  val first = List(1, 3, 4)
  val second = List(0, 2, 5)
  mergeTwoLists(first, second).foreach(println)

  def mergeTwoLists(list1: List[Int], list2: List[Int]): List[Int] = {
    @tailrec
    def merger(l1: List[Int], l2: List[Int], accumulator: List[Int]): List[Int] = {
      (l1, l2) match {
        case(Nil, hd :: tail) => merger(Nil, tail, accumulator :+ hd)
        case(hd :: tail, Nil) => merger(tail, Nil, accumulator :+ hd)
        case(hd1 :: tail1, hd2 :: tail2) => {
          if(hd1 < hd2) merger(tail1, hd2 :: tail2, accumulator :+ hd1)
          else merger(hd1 :: tail1, tail2, accumulator :+ hd2)
        }
        case (Nil, Nil) => accumulator
      }
    }
    merger(list1, list2, List.empty)
  }
}
