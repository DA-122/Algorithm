// 力扣117 构建回文串检测
// 思路分析：前缀和+位运算

// 子串可以重排。可以统计每个子串每个字符的奇偶状态，如果奇数数量/2 < k，那么肯定是可以变为回文的。
// 统计- 可以使用前缀和完成
// 数据规模 10^5， 前缀 10^5 *26，太大了，可以用位来表示

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int [] sum = new int[s.length()];
        sum[0] = (1 << (s.charAt(0) - 'a'));
        for(int i = 1; i < s.length(); i++){
            int bit =  (1 << (s.charAt(i) - 'a'));
            sum[i] = sum[i-1] ^ bit;
        }
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == queries[i][1]){
                res.add(true);
                continue;
            }
            int left = queries[i][0];
            int right = queries[i][1];
            int num = 0;
            int bit = sum[right];
            if(left != 0){
                bit = bit ^ sum[left-1];
            }
            for(int j = 0; j < 26; j++){
                if(((bit >> j)&1) == 1){
                    num++;
                }
            }
            if(num / 2 <= queries[i][2]){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
    public static void main(String args[]){
        int [][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        String s = "abcda";
        canMakePaliQueries(s, queries);
        
    }
}