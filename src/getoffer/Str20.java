package getoffer;

/**
 * @author sukbear
 * @create 2019-02-28 11:28
 */
public class Str20 {
    /**将一个字符串中的空格替换成“%20”。
    例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/
    static String replacePace(String str){
        if(str==null){return null;}
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<str.length();i++){
            if(String.valueOf(str.charAt(i)).equals(" ")){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        System.out.println(Str20.replacePace("we are happy"));
    }
}
