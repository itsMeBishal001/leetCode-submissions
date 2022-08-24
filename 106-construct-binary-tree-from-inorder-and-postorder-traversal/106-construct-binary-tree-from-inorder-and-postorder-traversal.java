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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
       return buildTree(inorder,0,n-1,postorder,0,n-1);
        
    }
    
    public TreeNode buildTree(int[] inorder,int isi,int iei, int[] postorder,int psi,int pei){
        if(isi>iei||psi>pei||pei<0||iei<0)return null;
        TreeNode root=new TreeNode(postorder[pei]);
        
        int idx=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                idx = i;
                break;
            }
        }
           
        
        int tel=psi+idx-isi;
       

        root.left=buildTree(inorder,isi,idx-1,postorder,psi,tel-1);
        root.right=buildTree(inorder,idx+1,iei,postorder,tel,pei-1);
        return root;
    }
}