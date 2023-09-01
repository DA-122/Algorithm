// ע�������ȫ������,����������һ������
// ʱ�临�Ӷ�Ҫ��O(n)

// ��1���ֲ�������
// ��ԭ���鰴����ż�ָ�Ϊk����������
// ÿ��ȡ�����������ұߵ���
// ��2����̬�滮
// ��3�����������Ż���ÿ��f[i] g[i]״̬����f[i-1] g[i-1]�й�
// �����˵ ������������Ʊʱ����
 
public class Solution {
    // ��3
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long even = nums[0], odd = 0;
        for(int i = 1; i < n; i++){
            even = Math.max(odd + nums[i], even);
            odd = Math.max(even - nums[i], odd);
        }
        return Math.max(even,odd);
    }
}
