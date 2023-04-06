// 1653 使字符串平衡的最小删除次数
// 思路分析：假设从后往前,如果末尾元素是b，那么不用删除
// 如果末尾元素是a，那么选择删除a或者删除a前所有b元素，因此需要记录b元素数量
// 递推公式： dp[i] = Math.min(dp[i-1]+1,cntB[i])
// 简化数组，用三个变量即可表示
public class Solution {
    // dp 
    public static int minimumDeletionsDp(String s) {
        int ans = 0, cntB =0;
        for(int i =0; i <s.length();i++){
            if(s.charAt(i == 'a')){
                ans = Math.min(ans+1;cntB);
            }else{
                cntB++;
            }
        }
        return ans;
    }
    // 按分割线枚举, 分割线前删除b，分割线后删除a
    public static int minimumDeletionsEnum(String s) {
        int cntA = 0, cntB = 0;
        for(char word: s.toCharArray()){
            if(word =='a'){
                cntA++;
            }
        }
        int ans = cntA;
        for(char word: s.toCharArray()){
            if(word=='a'){
                cntA--;
            }else{
                cntB++;
            }
            ans = Math.min(ans,cntA+cntB);
        }
        return ans;
    }
}