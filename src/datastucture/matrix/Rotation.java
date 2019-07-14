package datastucture.matrix;

import java.util.LinkedList;
import java.util.List;

/***
 *@ClassName Rotation
 *@Description
 * @author sukbear
 * @create 2019-04-22 11:16
 */
public class Rotation {
    /**有限状态机
     *
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     *
     * 输入:
     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]
     输出: [1,2,3,6,9,8,7,4,5]
     * */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int upLimit=0,downLimit=matrix.length-1,leftLimit=0,rightLimit=matrix[0].length-1;
        int x = 0,y = 0;
        // 0 向右走，1 向下走，2 向左走，3 向上走
        int status = 0;
        int size = matrix.length * matrix[0].length;
        while(0 < size){
            switch(status){
                case 0 : for(;y <= rightLimit;y++,size--){list.add(matrix[x][y]);}x++;y--;status=1;upLimit++;break;
                case 1 : for(;x <= downLimit;x++,size--){list.add(matrix[x][y]);}x--;y--;status=2;rightLimit--;break;
                case 2 : for(;y >= leftLimit;y--,size--){list.add(matrix[x][y]);}x--;y++;status=3;downLimit--;break;
                case 3 : for(;x >= upLimit;x--,size--){list.add(matrix[x][y]);}x++;y++;status=0;leftLimit++;break;
                default:
            }
        }
        return list;
    }
}
