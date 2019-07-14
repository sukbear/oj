package algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/***
 *@ClassName GenerateParenthesis
 *@Description
 * @author sukbear
 * @create 2019-04-18 20:38
 */
public class GenerateParenthesis {

/**    给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

    例如，给出 n = 3，生成结果为：

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 对于回溯法来说，必须齐备的三要素：

 1、选择。在这个例子中，解就是一个合法的括号组合形式，而选择无非是放入左括号，还是放入右括号;

 2、条件。在这个例子中，选择是放入左括号，还是放入右括号，是有条件约束的，不是随便放的。
   而这个约束就是括号的数量。只有剩下的右括号比左括号多，才能放右括号。
 只有左括号数量大于0才能放入左括号。这里if的顺序会影响输出的顺序，但是不影响最终解;

 3、结束。这里的结束条件很显然就是，左右括号都放完了。

 */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans,"",0,0,n);
        return ans;
    }
    private static void backtrack(List<String> ans,String cur,int left, int right, int max){
        //结束（括号都放完了）
        if(cur.length()==max*2){
            ans.add(cur);
            return;
        }
        //左括号没放完放
        if(left<max){
            backtrack(ans,cur+"(",left+1,right,max);
        }
        //右括号少于左括号
        if(right<left){
            backtrack(ans,cur+")",left,right+1,max);
        }
    }
    public static void main(String[] args) {
       for(String s:generateParenthesis(3)){
           System.out.println(s);
       }
    }
}
