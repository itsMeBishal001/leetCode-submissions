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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
         List<Integer> leafs1=leafs(root1);
        List<Integer> leafs2=leafs(root2);
        return leafs1.equals(leafs2);
    }
    
    public List<Integer>  leafs(TreeNode root){
        
         if(root==null)return new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        
       if(root.left==null&&root.right==null) ans.add(root.val);
        List <Integer> left=leafs(root.left);
                if(left.size()>0){
                for(Integer x :left)
                ans.add(x);
             }
        List<Integer>  right=leafs(root.right);
        if(right.size()>0){
        for(Integer x :right)
            ans.add(x);
        
        }
        return ans;
    }
}