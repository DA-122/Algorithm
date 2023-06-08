// 力扣2352 相等行列对
// 思路分析：
// 暴力 算法复杂度O(n^3)
// 行列内比较(去重) 哈希表行列间比较 优化到O(n^2)
public class Solution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>,Integer> map = new HashMap<>();
        int res = 0;
        // 行
        for(int i = 0; i < grid.length; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ;j < grid[0].length ; j++){
                list.add(grid[i][j]);
            }
            map.put(list,map.getOrDefault(list,0)+1);
        }
        for(int i = 0; i < grid.length; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ;j < grid[0].length ; j++){
                list.add(grid[j][i]);
            }
            res += map.getOrDefault(list,0);
        }
        return res;
    }
}
