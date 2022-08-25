/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0;
       // int sum=0;
       //  TreeNode x=leftMost(root) ;
       //  if(x!=null&&x.left==null&&x.right==null){
       //      sum+=x.val;
       //  }
       //  // sum+=sumOfLeftLeaves(root.left);
       //  sum+=sumOfLeftLeaves(root.right);
       //  return sum;
        
        // Checking if left Node is a leaf node
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }

		// Exploring the tree further.
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
      
    }
    public TreeNode leftMost(TreeNode node){
        TreeNode temp=node;
        while(node.left!=null)
            node=node.left;
        
        return temp!=node?node:null;
        
        
        
    }
}