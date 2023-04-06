import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 排序+前缀和+二分查找
public class Solution {
    public static List<Long> minOperations(int[] nums, int[] queries) {
        int length = nums.length;
        List<Long> answer = new ArrayList<>();
        long []sums = new long[length];
        // 排序
        Arrays.sort(nums);
        // 前缀和
        sums[0] = nums[0];
        for(int i = 1; i < length; i++){
            sums[i] = sums[i-1]+nums[i];
        }
        for(int i = 0; i < queries.length; i++){
            long ans = 0;
            if(queries[i] < nums[0]){
                ans = Math.abs(queries[i]*length - sums[length-1]);
            }else{
                int pivot = binarySearch(queries[i],nums);
                ans = (pivot+1)*queries[i]-sums[pivot] + (sums[length-1]-sums[pivot]) - (length-pivot-1)*queries[i];
            }
            answer.add(ans);
        }
        return answer;
    }
    // 二分查找target的下标
    public static int binarySearch(int target, int[] nums){
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = l+ (r - l)/2;
            if(target>nums[mid]){
                l = mid+1;
            }else if(target < nums[mid]){
                r = mid-1;
            }else{
                return mid;
            }
        }
        return l-1;
    }
    public static void main(String[] args){
        int[] nums ={3,1,6,8};
        int[] queries = {1,5};
        System.out.println(minOperations(nums, queries));
    }
}