// 力扣977. 有序数组的平方
// 思路分析：双指针
public class Solution{
    public static int[] sortedSquares(int[] nums) {
        int [] ans = new int[nums.length];
        int cur = 0;
        int right = 0;
        int left =0;
        while( right < nums.length && nums[right] < 0){
            right++;
        }
        while(left >=0 && right < nums.length){
            if(nums[right] <= -nums[left]){
                ans[cur] = nums[right]*nums[right];
                right++;
            } else{
                ans[cur] = nums[left]*nums[left];
                left--;
            }
            cur++;
        }
        while(left >=0){
            ans[cur] = nums[left]*nums[left];
            left--;
            cur++;
        }
        while(right < nums.length){
            ans[cur] = nums[right]*nums[right];
            right++;
            cur++;
        }
        return ans;
    }
    public static void main(String[] args){
        int []nums ={-4,-1,0,3,10};
        sortedSquares(nums);
    }
}