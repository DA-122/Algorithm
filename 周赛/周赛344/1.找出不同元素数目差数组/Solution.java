// 1.找出不同元素数目差数组

// 使用哈希表去重 模拟
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int prefix[] = new int [n];
        int postfix[] = new int [n];
        int[] diff = new int[n];
        for(int i = 0; i < n; i++){
            set1.add(nums[i]);
            prefix[i] = set1.size();
        }
        for(int j = n-1; j > 0; j--){
            set2.add(nums[j]);
            postfix[j-1] = set2.size();
        }
        for(int i = 0; i < nums.length; i++){
            diff[i] = prefix[i] - postfix[i];
        }
        return diff;
        
    }
}