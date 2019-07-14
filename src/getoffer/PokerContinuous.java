package getoffer;


import java.util.Arrays;

/**
 * @author sukbear
 * @create 2019-03-02 9:48
 *
 * /**
 * 从扑克牌中随机抽 5 张牌，判断是不是一个顺子，
 * 即这 5 张牌是不是连续的。2~10 为数字本身，
 * A 为 1，J 为 11，Q 为 12，K 为 13，而大、小王可以看成任意数字 0
 */

public class PokerContinuous {
    public static void main(String[] args) {
        int[] a = {0,0,4,6,9};
        System.out.println(PokerContinuous.pokerIsContinuous(a));
    }
    private static boolean pokerIsContinuous(int[] numbers) {
        if(numbers.length<5){
            return false;
        }
        Arrays.sort(numbers);
        //统计癞子数量
        int cnt=0;
        for(int v:numbers){
            if(v==0){
                cnt++;
            }
        }
        for(int i = cnt;i<numbers.length-1;i++){
            if(numbers[i]==numbers[i+1]){
                return false;
            }
            cnt -= numbers[i+1]-numbers[i]-1;
        }
        return cnt>=0;
    }
}
