package getoffer;

import java.util.Stack;

/**
 * @author sukbear
 * @create 2019-03-01 9:31
 */
public class MyStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(12);
        stack.push(9);
        System.out.println(stack.min());
    }
    private Stack<Integer> stack,stackHelp;

    public MyStack() {
        stack = new Stack<>();
        stackHelp = new Stack<>();
    }
    /**
     * stack与stackHelp 数量要一致。
     * 所以push操作，stack正常，stackHelp要判断入栈元素的大小，小于则元素直接入栈，
     * 否则，入栈栈顶最小元素。
     * */
    public  void push(int num){
        stack.push(num);
        if(stackHelp.size()==0||num <stackHelp.peek()){
            stackHelp.push(num);
        }else{
            stackHelp.push(stackHelp.peek());
        }
    }
    public void pop(){
        //同时弹出
        stack.pop();
        stackHelp.pop();
    }
    public Integer min(){
        if(stackHelp.size()==0){return null;}
        else{
            return stackHelp.peek();
        }
    }
}
