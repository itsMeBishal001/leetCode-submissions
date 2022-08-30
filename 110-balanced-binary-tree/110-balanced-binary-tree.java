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
    public class BTpair{
        boolean isBal=true;
        int h= -1;
    }
    public BTpair isBalanceds(TreeNode root) {
        
        if(root==null)return new BTpair();
        BTpair lp=isBalanceds(root.left);
         BTpair rp=isBalanceds(root.right);
        
        BTpair myPair=new BTpair();
         myPair.isBal=lp.isBal&& rp.isBal;
        if(myPair.isBal&&(Math.abs(lp.h-rp.h)<2)){
            myPair.h=Math.max(lp.h,rp.h)+1;
            //myPair.isBal=true;
          
        }else{
            myPair.isBal=false;
        }
        return myPair;
    }

    public boolean isBalanced(TreeNode root) {
      //  BTpair myPair=isBalanceds(root);
        
        return isBalanceds(root).isBal;
    }
}