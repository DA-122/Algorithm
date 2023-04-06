// ���� 70
// ���ƹ�ʽ: f(n) = f(n-1) + f(n-2)
// ��ʼ��: f(1) =1, f(2) = 2;
// ����˳��: ��ǰ����
public class Solution {
    // �ݹ鷽��
    public static int climbStairs(int n) {
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else
            return climbStairs(n-1)+climbStairs(n-2);
    }
    // ��������
    public static int  climbStairsIter(int n){
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else{
            int [] nums = new int[n];
            nums[0] = 1;
            nums[1] = 2;
            for(int i = 2; i < n; i++){
                nums[i] = nums[i-1]+nums[i-2];
            }
            return nums[n-1];
        }
    }
    public static void main(String[] args){
        System.out.println("Recursion:"+climbStairs(10));
        System.out.println("Iteration:"+climbStairsIter(10));
    }
}
