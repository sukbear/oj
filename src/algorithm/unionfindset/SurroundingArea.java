package algorithm.unionfindset;

/***
 *@ClassName SurroundingArea
 *@Description
 * @author sukbear
 * @create 2019-05-11 12:38
 */
public class SurroundingArea {
   /** 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

    X X X X
    X O O X
    X X O X
    X O X X

    X X X X
    X X X X
    X X X X
    X O X X

   首先对边界上每一个'O'做深度优先搜索，
    将与其相连的所有'O'改为'-'。然后遍历矩阵，
    将矩阵中所有'O'改为'X',将矩阵中所有'-'变为'O'

    */
   public void solve(char[][] board){
       if(board==null||board.length==0){
           return;
       }
       int row = board.length;
       int col = board[0].length;
       //
       for(int i = 0;i<row;i++){
           infect(board,i,0,row,col);
           infect(board,i,col-1,row,col);
       }
       for(int j=0;j<col;j++){
           infect(board,0,j,row,col);
           infect(board,row-1,j,row,col);
       }
       for(int i =0;i<row;i++){
           for(int j =0;j<col;j++){
               if(board[i][j]=='O'){
                   board[i][j]='X';
               }
               if(board[i][j]=='-'){
                   board[i][j]='O';
               }
           }
       }
   }
   /**
    * 将与边界相连的'O'修改为'-'
    * */
   private void infect(char[][] board,int i, int j, int row, int col){
       if(i<0||j<0||i>=row||j>=col||board[i][j]!='O'){
           return;
       }
       board[i][j]='-';
       infect(board,i-1,j,row,col);
       infect(board,i+1,j,row,col);
       infect(board,i,j-1,row,col);
       infect(board,i,j+1,row,col);
   }
}