import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
// 丑数：质因数只有2，3，5的数
// 思路分析：所有的丑数都可由丑数乘以2，3，5得到
// 1. 第n个数采用小根堆,只需要从1开始不断乘2，3，5，然后加入堆，取最小的丑数再乘2，3，5直到获得第n个丑数，还需要哈希表去重
// 2. 动态规划 + 三指针,dp[i]第i个丑数，p2,p3,p5三个指针，三指针分别指向 将要*2,*3,*5的丑数,
// 递推公式: dp[i] = min(dp[p2]*2,dp[p3]*3,dp[p5]*5) 如果dp[i] = dp[p2] p2++, p3 p5 同理            
// 初始化: p2 = p3 = p5 =1;
// 复杂度: 1. 时间O(nlogn) 空间O(n) 
// 2.时间O(n), 空间O(n)
public class Solution{
    public static int nthUglyNumber(int n) {
        // 小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2) {
                return num1 - num2;
            }
        });
        // 哈希
        int result = 1;
        queue.offer(result);
        Set<Integer> set = new HashSet<>();
        set.add(result);
        for(int i = 0; i < n; i++){
            result = queue.poll();
            int x1 = result*2;
            int x2 = result*3;
            int x3= result*5;
            if(!set.contains(x1)){
                queue.offer(x1);
                set.add(x1);
            }
            if(!set.contains(x2)){
                queue.offer(x2);
                set.add(x2);
            }
            if(!set.contains(x3)){
                queue.offer(x3);
                set.add(x3);
            }
        }
        return result;
    }
    public static int nthUglyNumberDp(int n) {
        int dp[]  = new int[n+1];
        int p2 =1, p3=1,p5=1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int num2 = dp[p2]*2;
            int num3 = dp[p3]*3;
            int num5 = dp[p5]*5;
            dp[i] = Math.min(Math.min(dp[p2]*2,dp[p3]*3),dp[p5]*5);
            if(dp[i] == num2){
                p2++;
            }
            if(dp[i] == num3){
                p3++;
            }
            if(dp[i] == num5){
                p5++;
            }

        }
        return dp[n];
    }
    public static void main(String[] args){
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }
}