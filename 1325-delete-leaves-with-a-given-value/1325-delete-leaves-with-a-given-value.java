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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null)return root;
        
        if(root.val==target&& leaf(root)){
          return   root=null;
        }
      root.left=  removeLeafNodes(root.left,target);
        if(root.val==target&& leaf(root)){
          return   root=null;
        }
       root.right= removeLeafNodes(root.right,target);
        if(root.val==target&& leaf(root)){
          return   root=null;
        }
        return root;
    }
    
    public boolean leaf(TreeNode node){
        if(node == null)return false;
        if(node.left==null && node.right==null)return true;
        
        return false;
    }
}