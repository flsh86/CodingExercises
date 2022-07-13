import scala.annotation.tailrec

object TwoSum extends App {
  val inputArray: Array[Int] = Array(3, 2, 95, 4, -3)
  val inputTarget: Int = 92

  def twoSumBrute(nums: Array[Int], target: Int): Array[Int] = {
    @tailrec
    def helper(x: Int, rest: Array[Int], hdIndex: Int): Array[Int] = {
      if (rest.isEmpty) {
        Array(-1, -1)
      }
      else if (rest.contains(target - x)) {
        Array(hdIndex, rest.indexOf(target - x) + hdIndex + 1)
      }
      else helper(rest.head, rest.tail, hdIndex + 1)
    }

    helper(nums.head, nums.tail, 0)
  }

  def twoSumMap(nums: Array[Int], target: Int): Array[Int] = {
    @tailrec
    def helper(index: Int, accumulator: Map[Int, Int]): Array[Int] = {
      val value = nums(index)
      accumulator get (target - value) match {
        case Some(someIndex) => Array(someIndex, index)
        case None => helper(index + 1, accumulator + (value -> index))
      }
    }

    helper(0, Map.empty)
  }

}