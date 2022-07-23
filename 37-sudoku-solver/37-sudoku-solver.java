class Solution {
    public void solveSudoku(char[][] board) {
          ArrayList<Integer>emptyIndex=new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if((board[i][j])=='.'){
                    emptyIndex.add(i*9+j);
                }
            }
           
            
        }
        solveSudoku(board,emptyIndex,0) ;
    }
    
    public boolean solveSudoku(char[][] board,ArrayList<Integer> emptyIndex,int idx){
        if(idx==emptyIndex.size()){
            return true;
        }
        
        int cell=emptyIndex.get(idx);
        int row=cell/9;
        int col=cell%9;
        for(int i=1;i<=9;i++){
            if(isSafe(board,row,col,i)){
                 board[row][col] = (char) (i + '0');
                
                
                if(solveSudoku(board,emptyIndex,idx+1))return true;
                board[row][col]='.';
            }
        }
        return false;
    }
    //checking on row & coloum & 3*3 box
    public boolean isSafe(char[][]board,int r ,int c,int num){
        //row check
         for(int i=0;i<9;i++){
             if((board[r][i]-'0')==num)
                 return false;
         }
        //coln check
         for(int i=0;i<9;i++){
             if((board[i][c]-'0')==num)
                 return false;
         }
        //on the small board 3*3
        
        //starting points
        r=(r/3) *3;
         c=(c/3) *3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if((board[r+i][c+j]-'0')==num)
                    return false;
            }
        }
        return true;
    }
    
    
    
    
}