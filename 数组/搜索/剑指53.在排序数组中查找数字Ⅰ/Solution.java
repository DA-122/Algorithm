// 剑指Offer53 - I. 在排序数组中查找数字 I
// 思路分析:二分查找

public class Solution{
    // 二分查找
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int low = 0, high = n-1;
        right = binarySearchRight(nums,target,low,high);
        left =  binarySearchLeft(nums,target,low,high);
        // 如果没找到元素left和right都会是0
        return left==0&&right==0? 0:right-left+1;
    }
    public static int binarySearchRight(int nums[], int target, int low, int high){
        int n =nums.length;
        int right = 0;
        while(low <= high){
            int mid = (low+high)/2;
            // 如果mid=target,看右侧是否不是target
            if(nums[mid] == target){
                if(mid == n-1 || nums[mid+1]!=target){
                    // 这里为了防止只有一个元素，加1
                    right = mid+1;
                    break;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }   
        return right;
    }
    public static int binarySearchLeft(int nums[], int target, int low, int high){
        int left = 0;
        while(low <= high){
            int mid = (low+high)/2;
            // 如果mid=target,看右侧是否不是target
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1]!=target){
                    left = mid;
                    break;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }   
        return left; 
    }


    

    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        System.out.println(search(nums, target));
    }
}