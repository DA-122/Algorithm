// 4.ʹ����������·��ֵ��ȵ���С��ֵ
// ˼·������̰���㷨
// ����ÿ���ֵ�Ҷ�ӽڵ㣬���˱��ڵ�ֵ��ͬ������ֵ����ȣ��Ķ�ֵΪmax - min
// ����ÿ�Է�Ҷ���ֵܽڵ㣬���˱��ڵ�ֵ�뺢�ӽڵ�ֵ��ͬ������ֵ����ͬ���Ķ�ֵΪmax - min
// ��˿����ܽ�Ϊ���������µ�·��ֵ��ͬ������ֵ����ͬ
public class Solution{


    public int minIncrements(int n, int[] cost) {
        int result = 0;
        // �����һ��Ҷ�ӽڵ㿪ʼ
        for(int i = n/2-1; i >= 0; i--){
            result += Math.abs(cost[i*2+1]- cost[i*2+2]);
            // ����parent cost
            cost[i] = cost[i] + Math.max(cost[i*2+1],cost[i*2+2]);
        }
        return result;
    }


    public static void main(String[] args){
    

    }
}