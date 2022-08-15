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
    public class pair{
        int h;
        int d;
        
        pair(){};
        pair(int h, int d){
            this.h = h;
            this.d = d;
        }
    }
    
    public pair diameter(TreeNode node){
        if(node == null){
            return new pair(-1, 0);
        }
        
        
        pair la = diameter(node.left);
        pair ra = diameter(node.right);
        
        pair my = new pair();
        
        my.h = Math.max(la.h , ra.h ) + 1;
        int accrossNode = la.h + ra.h + 2; 
        my.d = Math.max(accrossNode, Math.max(la.d, ra.d));
        
        return my;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        pair ans = diameter(root);
        return ans.d;
    }
}