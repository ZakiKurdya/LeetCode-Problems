class Solution {
    public boolean isvalid(char val,int r,int c,char[][] board){
        //row
        for(int j=0;j<9;j++){
            if( j!=c && board[r][j]==val )
            return false;
        }
        //Column
        for(int i=0;i<9;i++){
            if( i!=r && board[i][c]==val )
            return false;
        }

        //within 9*9 block
        int rs=3*(r/3);
        int cs=3*(c/3);
        for(int i=rs;i<rs+3;i++){
            for(int j=cs;j<cs+3;j++){
                if( i!=r && j!=c && board[i][j]==val){  ///the i row and j column are already checked 
                //therefore no need to check them again
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // For this ques we need to work for the block cases rest cases are easy to handle
        //For the block cases div the curent index row val with no of divison of rows Ex
        //for 3*3 block for (3,4) index row=3*3/3  and col=3*4/3
        //for 3*4 block for (4,6) index row=3*4/3  and col=4*6/4   (My own assumption)
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                boolean ans=isvalid(board[i][j],i,j,board);
                if(ans==false)
                return false;
                }

            }
        }
        return true;
    }

    // public boolean isValidSudoku(char[][] board) {
    //     return isRowsVaild(board) &&
    //            isColumnsVaild(board) &&
    //            isSquaresVaild(board);
    // }

    // private boolean isRowsVaild(char[][] board) {
    //      for (int i = 0; i < board.length; i++) {
    //         int[] freq = new int[10];
    //         for (int j = 0; j < board[0].length; j++) {
    //             if (board[i][j] == '.')
    //                 continue;
    //             if (freq[Integer.parseInt(String.valueOf(board[i][j]))] <= 1)
    //                 freq[Integer.parseInt(String.valueOf(board[i][j]))] += 1;
    //             else
    //                 return false;    
    //         }
    //     }
    //     return true;
    // }

    // private boolean isColumnsVaild(char[][] board) {
    //     for (int i = 0; i < board[0].length; i++) {
    //         int[] freq = new int[10];
    //         for (int j = 0; j < board.length; j++) {
    //             if (board[j][i] == '.')
    //                 continue;
    //             if (freq[Integer.parseInt(String.valueOf(board[j][i]))] <= 1)
    //                 freq[Integer.parseInt(String.valueOf(board[j][i]))] += 1;
    //             else
    //                 return false;    
    //         }
    //     }
    //     return true;
    // }

    // private boolean isSquaresVaild(char[][] board) {
    //     int[] points = {1, 4, 7};
    //     for (int p1 = 0; p1 < points.length; p1++) {
    //         for (int p2 = 0; p2 < points.length; p2++) {
    //             int[] freq = new int[10];
    //             if (board[j][i] == '.')
    //                 continue;
    //             if (freq[Integer.parseInt(String.valueOf(board[j][i]))] <= 1)
    //                 freq[Integer.parseInt(String.valueOf(board[j][i]))] += 1;
    //             else
    //                 return false;  
    //         }
    //     }
    // }
}