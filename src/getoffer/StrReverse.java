package getoffer;

/**
 * @author sukbear
 * @create 2019-03-02 10:16
 * <p>
 * /**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点
 * 符号和普通字母一样处理。
 * 例如输入字符串"I am student."，则输出"student. a am I"
 */
public class StrReverse {
    public static void main(String[] args) {
        String string = "I am a student.";
        reverseSentence(string );
    }


    private static void reverseSentence(String str) {
        if (str == null) {
            return;
        }
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int start = 0;
        for (char i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1;
            }
        }
        for(char c:arr){
            System.out.print(c);
        }
    }

    private static void reverse(char[] a, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
