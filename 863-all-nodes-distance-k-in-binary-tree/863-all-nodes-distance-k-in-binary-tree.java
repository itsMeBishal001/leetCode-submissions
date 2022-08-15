/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      List<TreeNode> n2R = nodeToRootPath(root, target.val);
        TreeNode blocker = null;
       List<Integer>ans = new ArrayList<>();
        for(int i = 0; i<n2R.size(); i++){
       TreeNode n = n2R.get(i);
      // ans.add(printKLevelsDown(n, k-i, blocker));
        List <Integer>anss=printKLevelsDown(n, k-i, blocker);
            for(int  x:anss)
                ans.add(x);
        blocker = n;
    }
        return ans;
    }
  public  List<Integer> printKLevelsDown(TreeNode node, int k, TreeNode blocker ){
        if(node == null || k < 0 || node == blocker){
             List<Integer> base = new ArrayList<>();
           return base;
        }
      List<Integer> ans= new ArrayList<>();
      
        if(k == 0){
            ans.add(node.val);
            return ans;
        }
       List<Integer>leftAns= printKLevelsDown(node.left, k-1, blocker);
      if(leftAns.size()>0){
          for(int x:leftAns){
              ans.add(x);
          }
      }
        List<Integer> rightAns=printKLevelsDown(node.right, k-1, blocker);
      if(rightAns.size()>0){
          for(int x:rightAns){
              ans.add(x);
          }
      }
         return  ans;
  }

//   public  void printKNodesFar(Node node, int data, int k) {
//     ArrayList<TreeNode> n2R = nodeToRootPath(node, data);
//     Node blocker = null;
    
//     for(int i = 0; i<n2R.size(); i++){
//         Node n = n2R.get(i);
//         printKLevelsDown(n, k-i, blocker);
//         blocker = n;
//     }
//   }
    public  List<TreeNode> nodeToRootPath(TreeNode node, int data){
       if(node == null){
            List<TreeNode> base = new ArrayList<>();
            return base;
        }
        if(node.val== data){
            List<TreeNode> base =new ArrayList<>();
            base.add(node);
            return base;
        }
        List<TreeNode> leftAns = nodeToRootPath(node.left, data);
        if(leftAns.size() > 0){
            leftAns.add(node);
            return leftAns;
        }
        List<TreeNode> rightAns = nodeToRootPath(node.right,data);
        if(rightAns.size()> 0){
            rightAns.add(node);
            return rightAns;
        }
        return new ArrayList<>();
      }
}