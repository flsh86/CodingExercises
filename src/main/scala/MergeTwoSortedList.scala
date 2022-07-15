object MergeTwoSortedList extends App{
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    val next: ListNode = _next
    val x: Int = _x
  }

  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    (list1, list2) match {
      case (null, _) => list2
      case (_, null) => list1
      case (l1, l2) => {
        if (l1.x < l2.x) new ListNode(l1.x, mergeTwoLists(l1.next, l2))
        else new ListNode(l2.x, mergeTwoLists(l1, l2.next))
      }
    }
  }
}
