object InvertBinaryTree extends App {
  class TreeNode(_value: Int, _left: TreeNode, _right: TreeNode) {
    var value = _value
    var left = _left
    var right = _right
  }

  val tree = TreeNode(4, TreeNode(
    2, TreeNode(1, null, null), TreeNode(3, null, null)),
    TreeNode(7, TreeNode(6, null, null), TreeNode(9, null, null))
  )

  def invertTree(root: TreeNode): TreeNode = {
    Option(root).map(node => TreeNode(node.value, invertTree(node.right), invertTree(node.left))).orNull
  }

}
