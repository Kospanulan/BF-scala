/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

import scala.collection.mutable.ListBuffer

object Solution {
    def increasingBST(root: TreeNode): TreeNode = {
        
        var elems = ListBuffer[Int]()
        elems = inOrder(root, elems)
        var ans: TreeNode = new TreeNode(elems(0))
        var thisNode: TreeNode = ans
        for(i <- 1 to elems.length-1){
            thisNode.right = new TreeNode(elems(i))
            thisNode = thisNode.right
        }
        
        return ans
    }
    
    def inOrder(node: TreeNode, immut_elems: ListBuffer[Int]): ListBuffer[Int] = {
        var elems = immut_elems
        if (node == null){
            return elems
        }
        inOrder(node.left, elems)
        elems.append(node.value)
        inOrder(node.right, elems)

        return elems
    }
    
    
}
