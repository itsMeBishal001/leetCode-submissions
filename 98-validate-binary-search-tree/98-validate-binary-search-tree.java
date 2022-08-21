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
    public boolean isValidBST(TreeNode root) {
        
     TreeNode curr=root;
        long prev=-(long)1e13;
        while(curr!=null){
            TreeNode left=curr.left;
            if(left==null){
                if(prev>=curr.val )return false;
                    prev=curr.val;
                // ans.add(curr.val);
            
                curr=curr.right;
            }else{
                TreeNode RMostNode=rightMostNode(left,curr);
                if(RMostNode.right==null){
                    RMostNode.right=curr;
                    curr=curr.left;
                }else{
                    RMostNode.right=null;
                    if(prev>=curr.val )return false;
                    prev=curr.val;
                    curr=curr.right;
                }
            }
        }
        return true;
    }
    
//     public boolean morisTraversalInOrder(TreeNode root){
//        // List<Integer> ans=new ArrayList<>();
//         TreeNode curr=root;
//         long prev=-(long)1e13;
//         while(curr!=null){
//             TreeNode left=curr.left;
//             if(left==null){
//                 if(prev>=curr.val )return false;
//                     prev=curr.val;
//                 // ans.add(curr.val);
            
//                 curr=curr.right;
//             }else{
//                 TreeNode RMostNode=rightMostNode(left,curr);
//                 if(RMostNode.right==null){
//                     RMostNode.right=curr;
//                     curr=curr.left;
//                 }else{
//                     RMostNode.right=null;
//                     if(prev>=curr.val )return false;
//                     prev=curr.val;
//                     curr=curr.right;
//                 }
//             }
//         }
//         return true;
//     }
    
    public TreeNode rightMostNode(TreeNode node,TreeNode curr){
        while(node.right!=null&&node.right!=curr){
            node=node.right;
        }
        return node;
    }
}