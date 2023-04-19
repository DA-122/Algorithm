// 力扣69. x的平方根
// 思路分析：实际上是找比x小的第一个平方数的平方根
public class Solution{
    public static int mySqrt(int x) {
        // mid*mid会越界，所以这里用long
        long ans = -1;
        long right = x;
        long left = 0;
        // left = right+1;
        while(left <= right){
            long mid = left + (right-left)/2;
            if(mid*mid > x){
                right = mid-1;
            }else if(mid*mid < x){
                left = mid+1;
            }else{
                ans = mid;
                break;
            }
        }
        if(ans == -1){
            ans = right;
        }
        return (int)ans;
    }
    public static void main(String[] args){
        int x = 10;
        mySqrt(x);
    }
}