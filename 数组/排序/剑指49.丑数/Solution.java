import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
// ������������ֻ��2��3��5����
// ˼·���������еĳ��������ɳ�������2��3��5�õ�
// 1. ��n��������С����,ֻ��Ҫ��1��ʼ���ϳ�2��3��5��Ȼ�����ѣ�ȡ��С�ĳ����ٳ�2��3��5ֱ����õ�n������������Ҫ��ϣ��ȥ��
// 2. ��̬�滮 + ��ָ��,dp[i]��i��������p2,p3,p5����ָ�룬��ָ��ֱ�ָ�� ��Ҫ*2,*3,*5�ĳ���,
// ���ƹ�ʽ: dp[i] = min(dp[p2]*2,dp[p3]*3,dp[p5]*5) ���dp[i] = dp[p2] p2++, p3 p5 ͬ��            
// ��ʼ��: p2 = p3 = p5 =1;
// ���Ӷ�: 1. ʱ��O(nlogn) �ռ�O(n) 
// 2.ʱ��O(n), �ռ�O(n)
public class Solution{
    public static int nthUglyNumber(int n) {
        // С����
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2) {
                return num1 - num2;
            }
        });
        // ��ϣ
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