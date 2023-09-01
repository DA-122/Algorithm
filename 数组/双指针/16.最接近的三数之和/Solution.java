// ��ӽ�������֮��
// ˼·������ �϶������� + ˫ָ��
// ʱ�临�Ӷ�O(n^2) �ռ临�Ӷ�O(1)
// �Ż���1. ˫ָ�����ƶ�ʱ�����������ͬ��Ԫ�أ���������
// 2. ���nums[i] + nums[i+1] + nums[i+2] > target����֮�����еı�������target����˿���ʡȥ�����ı���
// 3. ���nums[i] + nums[n-1] + nums[n-2] < target��֮���˫ָ�붼��targetС������ʡȥ˫ָ�룬ֱ�ӽ���������

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++){
            if( i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // ��֦2�����������ǰ��������֮�ʹ���target�����涼ֻ���target����
            int s = nums[i] + nums[i + 1] + nums[i + 2];
            if(s > target){
                if(s - target < min){
                    res = s;
                }
                break;
            }
            // ��֦3����������nums[i] �Ӻ���������֮��С��target���Ͳ���Ҫ�����˫ָ����
            s = nums[i] + nums[n-2] + nums[n-1];
            if(s < target){
                if(target - s < min){
                    min = target - s;
                    res = s;
                }
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < min){
                    min = Math.abs(sum - target);
                    res = sum;
                }
                // �Ż�1
                if(sum > target){
                    right--;
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }else if(sum < target){
                    left++;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }else{
                    return target;
                }
            }
        }
        return res;
    }
}