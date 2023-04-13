// 力扣1147. 段式回文
// 思路分析：1. 贪心算法+三指针(自解)
// 滚动哈希(官解)
public class Solution{
    public static int longestDecomposition(String text) {
        int n = text.length();
        int leftStart = 0;
        int leftEnd = 0;
        int right = n-1;
        int ans = 0;
        // 分成两段找前后缀
        while(leftEnd < n/2){
            // leftEnd不等于right，则不可能相等，继续向后找
            if(text.charAt(leftEnd)!=text.charAt(right)){
                leftEnd++;
            // 找到后挨个对比
            }else{
                int i = leftEnd;
                int j = right;
                while(i >= leftStart){
                    if(text.charAt(i) == text.charAt(j)){
                        j--;
                        i--;
                    }else{
                        break;
                    }
                }
                // 如果前后缀相等，更新指针参数
                if(i == leftStart-1){
                    right = j;
                    leftStart = leftEnd+1;
                    leftEnd = leftEnd+1;
                    ans = ans+2;
                // 不等leftEnd继续前移
                }else{
                    leftEnd++;
                }
            }
        }
        // leftEnd和leftStart差到1以上说明最中心存在一个无法分割的字符串
        // leftEnd = leftStart = right 说明最后三个都只到了中间一个字符上，奇数长度字符串
        if(leftEnd -leftStart >0 || leftEnd==leftStart&&leftEnd == right){
            ans+= 1;
        }
        return ans;
    }
    public static int longestDecomposition2(String text){

    }


    public static void main(String[] args){
        String text ="aaa";
        System.out.println(longestDecomposition(text));
    }
}