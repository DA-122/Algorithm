// ���ݷ�Χ������������˼򵥵�˫ָ�뻬�����ڲ��ʺ�
// ��3.ǰ׺�ͷ��� ʱ�临�Ӷ�O(n^2) �ռ临�Ӷ�O(n)
// ��4.ǰ׺��+ ��ϣ��ת��Ϊ����֮�� (���Ƿ��� sum[i] - k)

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0 ;
        int[] sums = new int[n];
        // key ǰ׺�� value ����ֵ���ִ���
        Map<Integer,Integer> map = new HashMap<>();
        sums[0] = nums[0];
        map.put(sums[0],1);
        if(sums[0] == k){
            res++;
        }
        for(int i = 1; i < n; i++){
            sums[i] = sums[i-1] + nums[i];
            // ǰ׺��
            if(map.containsKey(sums[i] - k)){
                res+= map.get(sums[i] - k);
            }
            // ���Ǳ�λǰ׺�� 
            if(sums[i] == k){
                res++;
            }
            map.put(sums[i],map.getOrDefault(sums[i],0)+1);
        }
        return res;
    }
}