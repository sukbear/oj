package algorithm.dp;


/***
 *@ClassName Word1Toword2
 *@Description
 * @author sukbear
 * @create 2019-04-16 16:05
 */
public class Word1Toword2 {

/***    给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

    你可以对一个单词进行如下三种操作：

    插入一个字符
 删除一个字符
    替换一个字符
 输入: word1 = "horse", word2 = "ros"
 输出: 3
 解释:
 horse -> rorse (将 'h' 替换为 'r')
 rorse -> rose (删除 'r')
 rose -> ros (删除 'e')


 dp[i][j]表示第一个word1[i]指针到第二个word[j]指针的编辑距离
 # dp[0][0] = 0 # 判断word1[i] ?= word2[j]，如等，则该位置两字符不需要编辑。
 # 如果word1[!] != word2[j].
 则有三种操作 # 如果是对word1[1] 插入，则插入后word1[i+1] = word2[j]，
 其dp = dp[i][j-1]
 # 删除 dp = dp[i-1][j]
 # 替换 dp = dp[i-1][j-1]
 # 操作数都加1
 # 取三个里面最小的

 */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][]dp = new int[m+1][n+1];
        for(int i =0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j = 0;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i =1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j] =1+min(min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public int min(int x,int y){
        return x<y?x:y;
    }
}
