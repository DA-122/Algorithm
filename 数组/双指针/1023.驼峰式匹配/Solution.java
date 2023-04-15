import java.util.ArrayList;
import java.util.List;

// 力扣1023 驼峰式匹配
// 题目分析：可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
// 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。

// 思路分析：1.双指针，一个指针指向query串，一个指针指向pattern串，如果两指针指向字符相等，移动指针，不相等，如果query串的指针是大写，则false。 
// 当pattern串指针移动到末尾时，query串剩余部分不应该有大写字母
// 当query串移动到末尾时，pattern串也应移动到末尾。
public class Solution{
    // 双指针法
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = pattern.length();
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            boolean isMatched = true;
            String str = queries[i];
            // pattern 指针
            int pivot = 0;
            for(int j = 0; j < str.length(); j++){
                if(pivot < n){
                    // 如果字符相等，移动模式串指针
                    if(str.charAt(j) == pattern.charAt(pivot)){
                        pivot++;
                    }else{
                        //如果queries的字符不等，且为大写，说明不正确
                        if(str.charAt(j) >= 'A' && str.charAt(j)<='Z')
                            isMatched = false;
                    }
                }else{
                    if(str.charAt(j) >= 'A' && str.charAt(j)<='Z')
                        isMatched = false;
                }
            }
            if(pivot < n)
                isMatched = false;
            ans.add(isMatched);
        }
        return ans;
    }
    public static void main(String[] args){
        String [] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern  = "FB";
        System.out.println(camelMatch(queries,pattern));
    }
}