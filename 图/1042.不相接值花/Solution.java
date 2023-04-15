// 力扣1042. 不邻接植花
// 思路分析： 图染色问题
public class Solution{
    public static int[] gardenNoAdj(int n, int[][] paths) {
        int ans[] = new int[n];
        // 构建起邻接表
        ArrayList<Integer> [] adj = new ArrayList [n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < paths.length; i++){
            adj[paths[i][0]-1].add(paths[i][1]-1);
            adj[paths[i][1]-1].add(paths[i][0]-1);
        }
        for(int i = 0;  i < ans.length; i++){
            boolean [] flower = new boolean[5];
            for(int j = 0 ; j < adj[i].size(); j++){
                flower[ans[adj[i].get(j)]] = true;
            }
            // 头节点没有种植花朵,从他的邻接节点中找没有种过的类型
            for(int j = 1; j < flower.length; j++){
                if(!flower[j]){
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;

    }
}