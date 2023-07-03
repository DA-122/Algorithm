// 力扣461. 汉明距离
// 思路分析： 异或，同0，不同1
// 右移判断每一位
class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int mid = x^y;
        for(int i = 0; i < 32; i++){
            if((mid & 1) == 1){
                res++;
            }
            mid = mid>>1;
        }
        return res;
    }
}