// 1072.按列翻转得到的最大值等行数
// 思路分析：哈希表找最大的互补|相等行组合数
// 只能变动列值，行值相等只能是互补或者相等的情况
import java.util.HashSet;
import java.util.Set;

public class Solution{
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        int result = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> set =new HashSet<>();
        for(int i = 0; i < n; i++){
            int cnt = 1;
            if(set.contains(i)){
                continue;
            }else{
                set.add(i);
            }
            for(int j = i+1; j < n; j++){
                if(set.contains(j)){
                    continue;
                }
                // 判断互补
                int k = 0;
                while( k < m){
                    if(matrix[i][k] == matrix[j][k]){
                        break;
                    }
                    k++;
                }
                if(k == m){
                    set.add(j);
                    cnt++;
                }
                k = 0;
                // 判断相等
                while( k < m){
                    if(matrix[i][k] != matrix[j][k]){
                        break;
                    }
                    k++;
                }
                if(k == m){
                    set.add(j);
                    cnt++;
                }
            }
            result = Math.max(cnt,result);
        }
        return result;
    }

    public static void main(String[] args){
        int matrix[][] = {{0,1},{1,1}};
        maxEqualRowsAfterFlips(matrix);
    }
}