// 力扣88 合并有序数组
// 思路： 非原地 双指针
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int res[] = new int[m+n];
        int pivot = 0, left = 0, right = 0;
        while(left < m && right < n){
            if(nums1[left] <= nums2[right]){
                res[pivot++] = nums1[left++];
            }else{
                res[pivot++] = nums2[right++];
            }
        }
        while(left < m){
            res[pivot++] = nums1[left++];
        }
        while(right < n){
            res[pivot++] = nums2[right++];
        }
        for(int i = 0; i < res.length; i++){
            nums1[i] = res[i];
        }
    }
}