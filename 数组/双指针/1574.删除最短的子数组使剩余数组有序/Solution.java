// 力扣1574. 删除最短的子数组使剩余数组有序
// 思路分析： 要求删除一个最短连续子数组，使得剩余数组元素非递减
// 由于是删除连续，因此剩余的数组元素肯定包含第一个或最后一个元素，因此需要求出包含开头或最后一个元素的有序子数组，有下面三种情况
// 1 删除开头一段 ans = right;
// 2 删除末尾一段 ans = arr.length-left-1
// 3 删除中间一段 遍历right，固定right(i)，遍历left(j)，删除的长度为 i-j-1
public class Solution {
    public static int findLengthOfShortestSubarray(int[] arr) {
        int ans = arr.length-1;
        int left = 0;
        int right = arr.length-1;
        // 开头一段
        for(int i = 1; i < arr.length; i++){
            if(arr[i] >= arr[i-1]){
                left = i;
            }else{
                break;
            }
        }
        if(left == arr.length-1){
            return 0;
        }
        // 末尾一段
        for(int i = right-1; i>0; i--){
            if(arr[i] <= arr[i+1]){
                right =  i;
            }else{
                break;
            }
        }
        // 只留末尾一段
        ans = Math.min(right,ans);
        // 只留开头一段
        ans = Math.min(ans, arr.length-left-1);
        // 中间一段
        for(int i = right; i < arr.length; i++){
            for(int j = left; j >= 0; j--){
                if(arr[i] >= arr[j]){
                    ans = Math.min(ans,i-j-1);
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String [] args){
        int[] arr = {1,2,3,10,0,7,8,9};
        System.out.println(findLengthOfShortestSubarray(arr));
    }
}