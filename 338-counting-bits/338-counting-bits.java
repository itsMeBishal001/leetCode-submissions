class Solution {
    public int[] countBits(int n) {
        int []arr=new int[n+1];
        for(int i=0;i<n+1;i++){
            arr[i]= hammingWeight_03(i);
        }
        return arr;
    }
    public int hammingWeight_03(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }

        return count;
    }
}