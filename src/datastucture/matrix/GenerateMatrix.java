package datastucture.matrix;

/***
 *@ClassName GenerateMatrix
 *@Description
 * @author sukbear
 * @create 2019-04-22 16:34
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int x = 0, y = 0;
        int up = 0, down = n - 1, left = 0, right = n - 1;
        //有限状态机
        int status = 0;
        int size=0;
        int val = 1;
        while(size<n*n){
            //通过改变上下左右限制来实现；
            switch (status){
                case 0:for(;y<=right;y++,size++){res[x][y]=val++;}x++;y--;up++;status=1;break;
                case 1:for(;x<=down;x++,size++){res[x][y]=val++;}x--;y--;right--;status=2;break;
                case 2:for(;y>=left;y--,size++){res[x][y]=val++;}x--;y++;down--;status=3;break;
                case 3:for(;x>=up;x--,size++){res[x][y]=val++;}x++;y++;left++;status=0;break;
               default:
            }
        }
        return res;
    }
}
