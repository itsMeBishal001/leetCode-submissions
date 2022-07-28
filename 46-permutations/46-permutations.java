class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
    boolean[]visited = new boolean[nums.length];
    
    Permutations(nums,visited,res,new ArrayList<>());
    return res;
    }
    public void Permutations(int []nums , boolean[]visited , List<List<Integer>> res,List<Integer>ans){
    
   
    
    if(ans.size() == nums.length){
        res.add(new ArrayList<>(ans));
        return;
    }
    
    for(int i = 0; i<nums.length; i++){
        
        if(visited[i] == false){
            
            visited[i] = true;
            ans.add(nums[i]);
            
            Permutations(nums,visited,res,ans);
            
            ans.remove(ans.size()-1);
            visited[i] = false;
        }
    }
}
}