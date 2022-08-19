class Solution {
    public List<Integer> intersection(int[][] nums) {
         ArrayList<Integer> arrList = new ArrayList<Integer>();
        List<Integer> resList = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                arrList.add(nums[i][j]); // adding all the elements of nums in arrList
            }
        }
        
        int numLength = nums.length;
        int count = 0;
        
        for(int i = 0; i < nums[0].length; i++){
            for(int j = 0; j < arrList.size(); j++){
                if(nums[0][i] == arrList.get(j)){
                    count++;    //increase count of nums[0][i] 
                }
            }
            if(count == numLength){
                resList.add(nums[0][i]);    //if nums[0][i] count is equals 3 then add to another array
            }
            count = 0;
        }
        
        Collections.sort(resList);// sort the result array
        
        return resList;
    }
}