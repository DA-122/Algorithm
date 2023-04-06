import java.util.HashSet;
import java.util.Set;

// ��ָ03 �����еĸ��ظ�����
// ˼·������1.��ϣ�� �ռ临�Ӷ�O(N)��ʱ�临�Ӷ�O(N)
// 2. ԭ�ؽ���, ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(1)
public class Solution{
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }else{
                set.add(nums[i]);
            }
        }
        return -1;
    }
    //��0��ʼ����ÿ��λ���ϵ����ֽ�����������Ӧ���ڵ�λ���ϣ�
    //(1) ������־���ԭӦ���ڵ�λ���ϣ����� nums[i] = i��    
    //(2) ���ֵ���ԭλ�õ����֣����ҵ��ظ����� nums[i]!=i nums[nums[i]] = nums[i]
    //(3) ������������ǵĻ� ����nums[i] ����nums[i]λ����ȥ
    // ע��ֻ���ڵ�һ�������i++������ҵ���iλ���ϵ�����
    public static int findRepeatNumber2(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i])
                return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
        System.out.print(findRepeatNumber2(nums));
    }
}