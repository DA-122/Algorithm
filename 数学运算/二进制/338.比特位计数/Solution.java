// 338.比特位计数

// 1. 相当于10进制数转2进制 时间O(nlogn) 
// 2. 动态规划 对于奇数 res[i] = res[i-1] + 1 //最低位为1，一定比前面的偶数多一位
// 对于偶数res[i] = res[i/2] 进位 1总位数不变
// 时间复杂度 O(N)
public class Solution{    
    public int[] countBits(int n) {
        int res [] = new int[n + 1];
        for(int i = 0; i <= n; i++){
            int num = i;
            while(num!=0){
                if(num % 2 == 1){
                    res[i]++;
                }
                num = num / 2;
            }
        }
        return res;
    }
    public int[] countBits2(int n){
        int res [] = new int[n + 1];
        for(int i = 0; i <= n; i++){
            if(i % 2  == 1){
                res[i] = res[i - 1] + 1;
            }else{
                res[i] = res[i / 2];
            }
        }
        return res;

    }
}