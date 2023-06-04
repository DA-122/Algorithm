import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Solution{
        public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int up = 0, down = 0;
        ans.add(new ArrayList(Arrays.asList(nums1[up],nums2[down])));
        int cnt = 1;
        while(cnt < k && up < nums1.length-1 && down < nums2.length-1){
            if((nums1[up+1] - nums1[up]) <= (nums2[down+1] - nums2[down])){
                up++;
            }else{
                down++;
            }
            ans.add(new ArrayList<>(Arrays.asList(nums1[up],nums2[down])));
            cnt++;
        }
        while(cnt < k && down < nums2.length-1){
            ans.add(new ArrayList<>(Arrays.asList(nums1[up],nums2[++down])));
            cnt++;
        }
        while(cnt < k && up < nums1.length-1){
            ans.add(new ArrayList<>(Arrays.asList(nums1[++up],nums2[down])));
            cnt++;
        }
        return ans;
    }
    public static void main(String[] args){
        int nums1[] = {1,7,11};
        int nums2[] = {2,4,6};
        int k = 3;
        kSmallestPairs(nums1, nums2, k);
    }
}