import java.util.Arrays;

class Solution {
    public static int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length;
        int n = nums.length; 
        int[] sums = new int[n+1];
        int[] answer = new int[m];
        Arrays.sort(nums);
        for(int i = 1; i < n+1; i++){
            sums[i] =sums[i-1]+nums[i-1];
        }
        for(int i = 0; i < queries.length; i++){
            int num = queries[i];
            int left = 1;
            int right = n+1;
            while(left < right){
                int mid = (left + right)/2;
                if(num >= sums[mid]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            answer[i] = left-1;
        }
        return answer;
    }
    public static void main(String[] args){
        int[] nums = {4,5,2,1};
        int[] queries = {3,10,21};
        System.out.println(answerQueries(nums, queries));
        
    }
} 
