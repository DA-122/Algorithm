// 周赛351. 得到整数零需要执行的最少操作数
// 位运算
// 分解成2的幂的加法

class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        if(num1 < num2){
            return -1;
        }
        int ans = 0;
        long mid = num1;
        while(mid > 0){
            mid -= num2;
            ans++;
            if(ans >= bitCnt(mid)&& ans <= mid){
                return ans;   
            }
        }
        return -1;
    }
    public int bitCnt(long num){
        int cnt = 0;
        for(int i = 0; i < 64; i++){
            if((num & 1) == 1){
                cnt++;
            }
            num = num >> 1;
        }        
        return cnt;
    }
}