// ����704 ���ֲ���
// ��Ŀ�� ����һ�� n ��Ԫ������ģ������������� nums ��һ��Ŀ��ֵ target  ��дһ���������� nums �е� target�����Ŀ��ֵ���ڷ����±꣬���򷵻� -1��

public class Solution{
    public static int search(int[] nums, int target) {
        int ans = -1;
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left+(right-left)/2;
            if(target < nums[mid]){
                right = mid-1;
            }else if (target > nums[mid]){
                left = mid+1;
            }else{
                ans = mid;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int []nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
}