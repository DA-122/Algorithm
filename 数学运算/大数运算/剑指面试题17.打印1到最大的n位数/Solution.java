// 剑指面试题：打印1到最大n位数
// 题目分析：难点在于大数情况，简单情况下只需遍历[1,10^n-1]即可
// 但是如果考虑大数情况，10^n存在越界风险，不能简单遍历。
// 大数情况下思路分析：
//  分治，固定高位，组合低位，通过递归来组合数字
//  组合完毕后需要对数字字符串头的0进行删除
public class Solution{
    StringBuffer buffer = new StringBuffer();
    public char[] nums;
    public char[] loop = {'0','1','2','3','4','5','6','7','8','9'};;
    int nine = 0, count = 0, start, n;

    // 简单题：返回int列表，n为int，不考虑大数的情况
    public int[] printNumbers(int n) {
        int length = (int)Math.pow(10,n)-1;
        int[] ans = new int[length];
        int i = 0;
        while(i < length){
            ans[i++] = i;
        }
        return ans;
    }
    // 进阶：考虑大数超界情况，返回类型应为字符串类型
    public String printNumbersH(int n){
        this.nums = new char[n];
        this.n = n;
        start = n-1;
        dfs(0);
        buffer.deleteCharAt(buffer.length()-1);
        return buffer.toString();
    }
    public void dfs(int x){
        if(x == n){
            String s = String.valueOf(nums).substring(start);
            if(!s.equals("0")) 
                buffer.append(s + ",");
            if(n - start == nine) start--;
                return;
        }   
        for(char i: loop){
            if(i == '9') nine++;
            nums[x] = i;
            dfs(x+1);
        }
        nine--;
    }
}
