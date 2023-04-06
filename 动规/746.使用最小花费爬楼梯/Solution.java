// ����746 ʹ����С������¥��
// ˼·����:F(n)������һ��������������
// ���ƹ�ʽ: totalCost[n] = min(totalCost[n-1]+cost[n-1],totalCost[n-2]+cost[n-2])
// ��ʼֵ: totalCost[0] = 0, totalCost[1] =0;
// ��������:��ǰ����
public class Solution {
    public static int minCostClimbingStairs(int[] cost) {
        int top = cost.length;
        if (top == 2){
            return Math.min(cost[1],cost[0]);
        }else{
            int [] totalCost = new int [top+1];
            totalCost[0] = 0;
            totalCost[1] = 0;
            for(int i = 2; i < totalCost.length; i++){
                totalCost[i] = Math.min(totalCost[i-1]+cost[i-1], totalCost[i-2]+cost[i-2]);
            }
            return totalCost[top];
        }
    }    

    public static void main(String[] args){
        int [] arg =  {10, 15, 20};
        System.out.println("Iteration:"+minCostClimbingStairs(arg));
    }
}
