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
     public int height(TreeNode node) {
    // write your code here
    if(node == null)
        return -1;
    int lh = height(node.left);
    int rh = height(node.right);
    
    return Math.max(lh, rh) + 1;
    
    
  }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0 ;
        
        int ld=diameterOfBinaryTree(root.left);
        int rd=diameterOfBinaryTree(root.right);
        int n=height(root.left)+height(root.right)+2;
        return Math.max(n,Math.max(ld,rd));
        
    }
}