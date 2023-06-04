import java.util.Arrays;

class Solution {
    public long maxStrength(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        Arrays.sort(nums);
        long ans = 1L;
        int n = nums.length;
        int positive = nums.length;
        int negative = -1;
        // �ҵ���һ������
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                positive = i;
                break;
            }
        }
        // �ҵ���һ������
        for(int i = n -1; i  >= 0; i--){
            if(nums[i] < 0){
                negative = i;
                break;
            }
        }
        if(positive == n && (negative == 0 || negative == -1)){
            return 0;
        }

        // ����ֱ�ӳ�
        for(int i = positive; i < n; i++){
            ans *= nums[i];
        }
        // ����ѡ��ż��
        if((negative + 1) % 2 == 0){
            for(int i = 0; i <= negative; i++){
                ans *= nums[i];
            }
        }else{
            for(int i = 0; i < negative; i++){
                ans *= nums[i];
            }
        }
        return ans;

    }

    public static void main(String[] args){
        int nums[] = {3,-1,-5,2,5,-9};
        maxStrength(nums);
    }
}