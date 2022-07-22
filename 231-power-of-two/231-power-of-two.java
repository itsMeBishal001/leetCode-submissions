class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<0)
            return false;
        if(hammingWeight_02(n)==1){
            return true;
        }
        return false;
    }
      public int hammingWeight_02(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0)
                count++;

            n >>>= 1;
        }

        return count;
    }
}