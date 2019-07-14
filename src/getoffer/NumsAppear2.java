package getoffer;

/**
 * @author sukbear
 * @create 2019-02-26 23:03
 * <p>
 * 有两个数出现一次，其他两次
 * 有一个数出现一次，其他3次
 */
public class NumsAppear2 {
    static int findNumberAppear(int[] arr) {
        int[] bitSum = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = arr[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }
        int res = 0;
        for(int i = 0; i<32;i++){
            res<<=1;
            res = res+bitSum[i]%3;
        }
        return res;
    }

    static int[] findNumsAppearOnce2(int[] arr) {
        //特殊情况处理
        if (arr.length <= 2) {
            return arr;
        }
        //要返回的结果
        int[] result = new int[2];
        int res = arr[0];
        //得到两个不同数异或的值
        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }
        //找出异或结果为“1”的bit index，32位 右移与有“1”与
        int bitindex = 0;
        for (int i = 0; i < 32; i++) {
            if (((res >> i) & 1) == 1) {
                bitindex = i;
                break;
            }
        }
        // //根据bitIndex为1，将元素分为两组
        for (int i = 0; i < arr.length; i++) {
            //为1的那组
            if ((arr[i] >> bitindex & 1) == 1) {
                result[0] ^= arr[i];
            } else {
                result[1] ^= arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3};
        int[] a = NumsAppear2.findNumsAppearOnce2(arr);
        System.out.println(a[0] + "  " + a[1]);

        int[] b = {2,2,4,-1};
        System.out.println(findNumberAppear(b));
    }
}
