class Solution {
    // public int fib(int n) {
    //     if(n<=1)return n;
    //     return fib(n-1)+fib(n-2);
    // }
    public int fib(int N) {
		if(N < 2){
			return N;
		}
		int x = 0;
		int y = 1;
		for(int i = 2; i <= N; i++){
			y = x + y;
			x = y - x;
		}
		return y;
	}
}