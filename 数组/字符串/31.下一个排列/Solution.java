// ����31. ��һ������

// ��nums�е���������ַ����ֵ䣬��Ȱ��ֵ��������ֵ����ǵ�ǰ˳����ɵ��ַ�����һ�����ַ���
// ���nums�ֵ��������ô��һ�������ֵ�����С
// ˼·������ �����ֵ��������ȫ����
// ��˴Ӻ���ǰ��Υ���˽���ԭ����������֣���nums[i] < nums[i+1]
// Ȼ��nums[i]�� [i+1, n]�б��������С���ֽ�������ʱ��[i+1, n]��Ȼ����ת�ü���

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int cur = n - 2;
        // Ѱ�ҵ�һ��nums[i] > nums[]
        while((cur >= 0 && nums[cur] >= nums[cur + 1])){
            cur--;                                                   
        }
        if(cur == -1){
            Arrays.sort(nums);
            return;
        }
        int max =  Integer.MAX_VALUE;
        int pos = 0;
        for(int i = cur + 1; i < n; i++){
            if(nums[cur] < nums[i]){
                // ע����ڵ����
                if(nums[i] <= max){
                    pos = i;
                    max = nums[pos];
                }
            }
        }
        int temp = nums[cur];
        nums[cur] = nums[pos];
        nums[pos] = temp;
        // // �������Ժ����������򣬾���ð�ݰɣ��������þ��У�
        // for (int i = 1 ; i < n - cur -1; i++){
        //     boolean flag = true;
        //     for(int j = cur+1; j < n - i; j++){
        //         if(nums[j] > nums[j+1]){
        //             temp = nums[j];
        //             nums[j] = nums[j+1];
        //             nums[j+1] = temp;
        //             flag = false;
        //         }
        //     }
        //     if(flag){
        //         break;
        //     }
        // }
        // ת��
        int left = cur+1, right = n-1;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        } 
    }                                                         
}             