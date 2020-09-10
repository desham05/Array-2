// Time Complexity : O(N*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        
        int n = board.length;
        int m = board[0].length;
        
        
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                int count = isAlive(board,n,m,i,j);
                
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 2;
                }else if(board[i][j] == 0 && count == 3){
                    board[i][j] = 4;
                }
            }
        }
        
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                int count = isAlive(board,n,m,i,j);
                
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 4){
                    board[i][j] = 1;
                }
            }
        }
        
    }
    
    private int isAlive(int[][] board,int n,int m, int i,int j){
        int[][] directions = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        
        int count=0;
        
        for(int[] dirs:directions){
            int r = i + dirs[0];
            int c = j + dirs[1];
        
            if(r<n && r>=0 && c<m && c>=0 && (board[r][c] == 1 || board[r][c] == 2)){
                count += 1;
            }
        
        }
        return count;
        
        
    }
}

