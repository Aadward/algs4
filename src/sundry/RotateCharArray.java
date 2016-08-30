package sundry;

/**
 * Created by syh20 on 2016/8/29.
 */
public class RotateCharArray {
    /**
     * 循环左移的char数组
     */
    public static void rotate(char[] chars, int n){
        int cLen = chars.length;
        n %= cLen;
        reverse(chars,0,n - 1);
        reverse(chars,n, cLen - 1);
        reverse(chars);
    }

    /**
     * 循环右移的char数组
     */
    public static void rotateR(char[] chars, int n){
        int cLen = chars.length;
        n %= cLen;
        reverse(chars,0,cLen - 1 - n);
        reverse(chars,cLen - n, cLen - 1);
        reverse(chars);
    }

    private static void reverse(char[] chars, int... index){
        int start = 0;
        int end = chars.length - 1;
        if(index.length == 2){
            start = index[0];
            end = index[1];
        }else if(index.length != 0){
            throw new RuntimeException("index's length has to be zero or two.");
        }
        if(end - start < 1)  return;
        while(start < end){
            chars[start] = (char)(chars[start] ^ chars[end]);
            chars[end] = (char)(chars[start] ^ chars[end]);
            chars[start] = (char)(chars[start] ^ chars[end]);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        char[] chars1 = s.toCharArray();
        rotate(chars1,3);
        for(char c : chars1){
            System.out.print(c);
        }
        System.out.println();
        char[] chars2 = s.toCharArray();
        rotateR(chars2,3);
        for(char c : chars2){
            System.out.print(c);
        }
    }
}
