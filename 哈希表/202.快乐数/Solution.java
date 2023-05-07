// 力扣202. 快乐数
// 思路分析：无限循环：出现了重复出现的数字()

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean isHappy(int n) {
        boolean result = false;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        set.add(n);
        while(n!=1){
            while(n!=0){
                int num = n%10;
                n = n/10;
                sum+=num*num;
            }
            if(set.contains(sum)){
                break;
            }            
            set.add(sum);
            n = sum;
            sum = 0;
        }
        if (n == 1){
            result = true;
        }
        return result;
    }
    public static void main(String[] args){
        int n = 19;
        isHappy(n);
    }
}

