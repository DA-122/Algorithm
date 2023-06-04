// 力扣2517. 礼盒的最大甜蜜度
// 思路分析：二分查找 + 贪心

import java.util.Arrays;

public class Solution {
    public static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0;
        int right = price[price.length - 1] - price[0];
        while(left < right){
            int mid = (left + right + 1) / 2;
            if(check(price,k,mid)){
                left = mid ;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public static boolean check(int[] price, int k , int tastiness){
        int prev = Integer.MIN_VALUE / 2;
        int cnt = 0;
        for (int p : price) {
            if (p - prev >= tastiness) {
                cnt++;
                prev = p;
            }
        }
        return cnt >= k;
    }
    public static void main(String[] args){
        int [] price = {13,5,1,8,21,2};
        int k = 3;
        maximumTastiness(price, k);
    }
}