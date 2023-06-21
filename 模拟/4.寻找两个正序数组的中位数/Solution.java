// 力扣4：寻找两个正序数组的中位数
// 思路分析：1.使用额外数组
// 2.双指针法，复杂条件判断
// 3.要求log(m+n)的复杂度，需要二分法
public class Solution {
    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) / 2;
        if(( m + n ) %2 == 0){
            mid = mid-1;
        }
        int pivot1 = 0;
        int pivot2 = 0;
        while(pivot1 < m && pivot2 < n && (pivot1 + pivot2) < mid){
            if(nums1[pivot1] < nums2[pivot2]){
                pivot1++;
            }else{
                pivot2++;
            }
        }
        // 数组的补足
        while(pivot1 + pivot2 < mid){
            while(pivot1 + pivot2 < mid && pivot1 < m){
                pivot1++;
            }
            while(pivot1 + pivot2 < mid && pivot2 < n){
                pivot2++;
            }
        }
        // 奇数
        if((m + n)%2 == 1){
            if(pivot1 < m && pivot2 < n){
                result = Math.min(nums1[pivot1],nums2[pivot2]);
            }else{
                if(pivot1 == m){
                    result = nums2[pivot2];
                }
                if(pivot2 == n){
                    result = nums1[pivot1];
                }
            }
        }else{
            // 偶数情况比较复杂，
            if(pivot1 == m){
                result += nums2[pivot2] + nums2[pivot2+1];
            }
            if(pivot2 == n){
                result += nums1[pivot1] + nums1[pivot1+1];
            }
            if(pivot1 < m && pivot2 < n){
                if(pivot1 == m-1 ){
                    if(nums1[pivot1] <= nums2[pivot2]){
                        result += nums1[pivot1] + nums2[pivot2];
                    }else{
                        result += nums2[pivot2] + Math.min(nums2[pivot2+1],nums1[pivot1]);
                    }
                }
                if(pivot2 == n - 1){
                    if(nums2[pivot2] <= nums1[pivot1]){
                        result += nums1[pivot1] + nums2[pivot2];
                    }else{
                        result += nums1[pivot1] + Math.min(nums1[pivot1+1],nums2[pivot2]);
                    }
                }
                if(pivot1 != m-1 && pivot2!= n-1){
                    if(nums1[pivot1] <= nums2[pivot2]){
                        result += nums1[pivot1] + Math.min(nums1[pivot1+1],nums2[pivot2]);
                    }else{
                        result += nums2[pivot2] + Math.min(nums2[pivot2+1],nums1[pivot1]);
                    }
                }
            }
            result = result / 2;
        }

        return result;
    }
    public static void main(String[] args){
        int[] nums1 = {1};
        int[] nums2 = {2};
        findMedianSortedArrays(nums1,nums2);
    }   
}
