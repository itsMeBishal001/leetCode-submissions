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
    public boolean isBalanced(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))return true;
        boolean left=isBalanced(root.left);
        if(left==false)return false;
         boolean right=isBalanced(root.right);
        if(right==false)return false;
        int lH=height(root.left);
        int rH=height(root.right);
        if(lH+1==rH||lH==rH+1||lH==rH)return true;
        return false;
    }
     public  int height(TreeNode root){
        if(root == null){
            return -1;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        int myAns = Math.max(lh, rh) + 1;
        return myAns;
    }
}