package getoffer;

import java.util.Arrays;

/***
 *@ClassName ValidSquare
 *@Description
 * @author sukbear
 * @create 2019-09-06 13:28
 */
public class ValidSquare {
    public static  boolean validSquare(int[]p1,int[]p2,int[]p3,int[] p4){
        int[][]p = {{p1[0],p1[1]},{p2[0],p2[1]},{p3[0],p3[1]},{p4[0],p4[1]}};
        int[] len = new int[6];
        int index = 0;
        for(int i = 0;i<4;i++){
            for(int j =i+1;j<4;j++){
                len[index++] =  (p[i][0]-p[j][0])*(p[i][0]-p[j][0])+(p[i][1]-p[j][1])*(p[i][1]-p[j][1]);
            }
        }
        Arrays.sort(len);
        return len[0]==len[3]&&len[4]==len[5]&&len[4]>len[0];
    }

    public static void main(String[] args) {
        int[] p1= {0,0};
        int[] p2= {0,1};
        int[] p3= {1,0};
        int[] p4= {1,1};
        System.out.println(validSquare(p1,p2,p3,p4));
    }
}