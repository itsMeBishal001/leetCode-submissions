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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new  ArrayList<>();
       ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> qu = new LinkedList<>();
        //seeding
        qu.add(root);

       while(qu.size() > 0 ){
            int size = qu.size();
           List<Integer> lAns =new  ArrayList<>();
           
            while(size-- > 0){
                //1. remove
                TreeNode rem = qu.remove();
            
                //2. Work
               lAns.add(rem.val);

                //3. Add all child If possible
                if(rem.left != null){
                    qu.add(rem.left);
                }
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            ans.add(lAns);
    }
        return ans;
}
    

        
}