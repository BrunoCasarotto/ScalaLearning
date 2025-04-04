object Solution {
  def lcaDeepestLeaves(root: TreeNode): TreeNode = {
    def dfs(node: TreeNode): (TreeNode, Int) = {
      if (node == null) return (null, 0)
      
      val (leftLCA, leftDepth) = dfs(node.left)
      val (rightLCA, rightDepth) = dfs(node.right)
      
      if (leftDepth > rightDepth) {
        (leftLCA, leftDepth + 1)
      } else if (rightDepth > leftDepth) {
        (rightLCA, rightDepth + 1)
      } else {
        (node, leftDepth + 1)
      }
    }
    
    dfs(root)._1
  }
}