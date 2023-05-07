// 力扣2418.按身高排序
// 思路分析：排序，将names和heights绑成二元组

import java.util.Arrays;

public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[indices[i]];
        }
        return res;
    }
}