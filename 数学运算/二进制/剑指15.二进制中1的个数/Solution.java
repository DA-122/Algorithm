// 剑指15.二进制中1的个数
// 思路分析：1.与运算判断低位是否为1，右移运算不断取低位，总共32次
// 2.用2^i与n做与运算，不移位来判断所有的位数是否为1
// 3.n&(n-1) 会把n最低位的1翻转为0；
// 例子 6(110) 5(101)  6&5=4(100)
// 4(100) 3(011) 4&3 = 000(0)
// 所以让n不断的与n-1去做与运算，翻转低位1，直到为0，翻转次数就是1的位数
public class Solution{
    public static int hammingWeight(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            ans += n&1;
            n = n>>1;
        }
        return ans;
    }
    public static int hammingWeight2(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            // 1左移i位，取到2^i-1 然后与n做与运算
            ans += n&((1 << i));
        }
        return ans;
    }
    // 时间复杂度O(logN)
    public static int hammingWeight3(int n) {
        int ans = 0;
        while(n!=0){
            n = n&(n-1);
            ans++;
        }
        return ans;
    }
    public static void main(String[] args){
        int n = 11;
        System.out.println(hammingWeight3(n));
    }
}
