// 力扣31. 下一个排列

// 用nums中的数字组成字符串字典，求比按字典序排序，字典中是当前顺序组成的字符串下一个的字符串
// 如果nums字典序最大，那么下一个就是字典序最小
// 思路分析： 数字字典序最大（完全降序）
// 因此从后向前找违背了降序原则的相邻数字，即nums[i] < nums[i+1]
// 然后将nums[i]和 [i+1, n]中比它大的最小数字交换，这时，[i+1, n]仍然降序，转置即可

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int cur = n - 2;
        // 寻找第一个nums[i] > nums[]
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
                // 注意等于的情况
                if(nums[i] <= max){
                    pos = i;
                    max = nums[pos];
                }
            }
        }
        int temp = nums[cur];
        nums[cur] = nums[pos];
        nums[pos] = temp;
        // // 接下来对后续部分排序，就用冒泡吧（这里逆置就行）
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
        // 转置
        int left = cur+1, right = n-1;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        } 
    }                                                         
}             