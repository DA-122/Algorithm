
//思路分析： 1. 暴力解法，把1到n的数字转化成二进制字符串，看是否是s子串
// 2. 计算s所有子串，存入到哈希表中，最后看哈希表长度是否为n


// 数学推导。长度为k + 1的二进制数总共有 2^k个,这些二进制数如果用一个字符串的子串来表示，则字符串长度m 至少为 k + 1 + 2^k -1(滑动窗口);
// 假设n的二进制长度是k+1：
// (1)区间[2^k,n]内的二进制长度为k+1，总共有n-2^k+1个,应满足 m>=k+1+(n-2^k+1-1) = n-2^k+k+1
// (2)区间[2^(k-1),2^k-1]内的二进制长度为k，总共有2^(k-1)个,应满足 m>=k+(2^(k-1)-1)
// (3)对于比这两个区间更小的区间来说，如果这两个区间的数都包含在字符串中，那么小区间可以通过右移得到，也一定在s中
// 特例：当n = 1时, k = 0，区间(2)不存在，因此直接判断s是否包含1
// 也就是说给定n和s,s.length = m
// 如果 m < max(n-2^k+k+1,2^(k-1)+k-1), m子串肯定无法表示[1,n]内的所有数字，因此可以直接返回false


// 此题中 m<=1000， n-1024+10+1 > 1000,即n> 2013时，可直接返回false
// max(n-2^k+k+1,2^(k-1)+k-1)大约时 n/2，因此n > 2m就可以返回false
// 因此思路一中最多遍历2m次


// 思路三 按照n和m的关系对算法1进行剪枝。用长度为k的滑动窗口，判断这两个区间是否存在即可。
// 时间复杂度O(m),空间复杂度O(min(m,n))

import java.util.HashSet;
import java.util.Set;

public class Solution{
    // 1. 数字转字符串
    public static boolean queryString1(String s, int n) {
        for(int i = 1; i <= n; i++){
            if(!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }
    // 2.计算所有子串
    public static boolean queryString2(String s, int n) {
        Set<Integer> set =new HashSet<>();
        char[] array = s.toCharArray();

        for(int i = 0; i < array.length; i++){
            int x = array[i] - '0';
            if(x == 0){
                continue;
            }
            // 剪枝
            for(int j = i + 1; x<=n; j++){
                set.add(x);
                if(j == array.length){
                    break;
                }
                if(array[j] - '0' == 0){
                    x = x << 1;
                }else{
                    x = (x << 1) + 1;
                }
            }
        }
        return set.size() == n;
    }
    // 3.剪枝方法1
    public static boolean queryString3(String s, int n) {
        if(n == 1){
            return s.contains("1");
        }
        // n的二进制长度-1
        int k = 31 - Integer.numberOfLeadingZeros(n);
        if(s.length()<Math.max(n-(1<<k)+k+1,(1<<(k-1)+k-1))){
            return false;
        }
        // 两个区间分别判断
        return check(s,k, n/2+1, (1<<k)-1)&& check(s,k+1,1<<k, n);
    }
    // 判断s子串是否有长度为k且在[lower,upper]范围内的二进制数
    // k位表示 2^(k-1) - 2^k-1
    public static boolean check(String s, int k, int lower, int upper){
        if(lower > upper){
            return true;
        }
        Set<Integer> set = new HashSet<>();
        int mask = (1 << (k-1) -1) ;    // 2^(k-1)-1 k个1  mask&x可以遮盖掉x的最高位
        int x  = Integer.parseInt(s.substring(0, k-1),2);
        for(int i = k-1; i < s.length(); i++){
            x = ((x&mask) << 1) + s.charAt(i) - '0';
            if(lower <= x && x <= upper){
                set.add(x);
            }
        }
        return set.size() == upper - lower + 1;
    }
    public static void main(String[] args){
        String s = "0110";
        int n = 3;
        queryString2(s, n);
    }
}
