package jianzhioffer.sisty;

/***
 *@ClassName TicketMaxProfit
 *@Description
 * @author sukbear
 * @create 2019-09-05 20:11
 */
public class TicketMaxProfit {
    public static int maxProfit(int[] price){
        if(price==null||price.length==0){
            return 0;
        }
        int minPrice = price[0];
        int maxProfit = 0;
        for(int i = 1;i<price.length;i++){
            minPrice = Math.min(minPrice,price[i]);
            maxProfit = Math.max(maxProfit,price[i]-minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        System.out.println(maxProfit(array));
    }
}
