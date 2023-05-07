// 周赛343 2.找出叠涂元素
// 思路分析： 哈希表记录数字与坐标对应关系，数组记录每行或每列元素数
// 分析清楚题意即可

import java.util.Map;
import java.util.HashMap;

public class Solution{
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int result = 0;
        int m = mat.length;
        int n = mat[0].length;
        int []rows = new int[m];
        int []cols = new int[n];
        Map<Integer,int[]> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = j;
                map.put(mat[i][j],pos);
            }
        }
        for(int i = 0; i < m*n; i++){
            int []pos = map.get(arr[i]);
            rows[pos[0]]++;
            cols[pos[1]]++;
            if(rows[pos[0]] == n||cols[pos[1]] == m){
                result = i;
                break;
            } 
        }
        return result;
    }
}