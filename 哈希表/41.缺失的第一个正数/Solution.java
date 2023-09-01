// ����41 ȱʧ�ĵ�һ������
// ��1. �޿ռ临�Ӷ�Ҫ�󣬹�ϣ��������Ԫ�ؼ��뵽��ϣ���У���1��N�������ж����Ƿ��ڱ���
// С�Ż������������и������������ü��뵽��ϣ���С�
// ��2. �пռ临�Ӷ�Ҫ�󣬹�ϣ�� + �û���ԭ�ع�ϣ����nums�������ɹ�ϣ��

import java.util.Set;
import java.util.HashSet;

public class Solution {

    // ��1 ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n)
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num > 0){
                set.add(num);
            }
        }
        for(int i = 1; i < n+1; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return n + 1;
    }
    // ��2 ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] <= n){
                int pos = nums[i] - 1;
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
                if(nums[i] == nums[pos]){
                    break;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] != i+1){
                return i + 1;
            }
        }
        return n + 1;
    }
}
