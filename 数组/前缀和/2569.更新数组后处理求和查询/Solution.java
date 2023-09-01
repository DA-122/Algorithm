// 

import java.util.List;
import java.util.ArrayList;

public class Solution{
    public static void main(String[] args){
        S s = new S();
        int[] nums1 = {1,0,1};
        int[] nums2 = {0,0,0};  
        int[][] queries = {{1,1,1},{2,1,0},{3,0,0}};
        s.handleQuery(nums1,nums2,queries);
    }
}


class S {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> list = new ArrayList<Long>();
        int[] sums = new int[nums1.length];
        long res = 0L;
        for(int i = 0; i < nums1.length; i++){
            res += nums2[i];
            if(nums1[i] == 1){
                sums[i] += sums[i - 1];
            }else{
                sums[i] = sums[i - 1];
            }
        }
        for(int i = 0; i < queries.length; i++){
            // 1 操作可以做一个归并集？
            if(queries[i][0] == 1){

            }else if(queries[i][0] == 2){
                for(int j = 0; j <= i; j++){
                    diff += nums2[j];
                }
            }else{
                res += diff;
                diff = 0;
                list.add(res);
            }
        }
        long [] ans = new long[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}   