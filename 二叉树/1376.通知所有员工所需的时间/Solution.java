// 1376.通知所有员工所需的时间
// 思路分析: (1)记忆化搜索遍历树，自底向上的遍历，哈希表存储已经遍历过的值  时间复杂度O(N)，空间复杂度O(N)
// (2) DFS和BFS 根据manager数组构建二叉树，转化为寻找最长路径  时间复杂度O(N)，空间复杂度O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution{
    // 记忆化搜索
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < n; i++){
            // 计算员工i接到通知的时间
            int boss = manager[i];
            int time = 0;
            while(boss!=-1){
                if(map.containsKey(boss)){
                    time+=map.get(boss)+informTime[boss];
                    break;
                }
                time+=informTime[boss];
                boss = manager[boss];
            }
            map.put(i,time);
            max = Math.max(time,max);
        }
        return max;
    }
    // DFS
    public int numOfMinutesDFS(int n, int headID, int[] manager, int[] informTime) {
        // 使用 HashMap 来构建图
        Map<Integer, List<Integer>> g = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            g.putIfAbsent(manager[i], new ArrayList<Integer>());
            g.get(manager[i]).add(i);
        }
        // 从根节点开始进行 DFS 并返回总时间
        return dfs(headID, informTime, g);
    }

    public int dfs(int cur, int[] informTime, Map<Integer, List<Integer>> g) {
        int res = 0;
        // 遍历当前节点的邻居节点
        for (int neighbor : g.getOrDefault(cur, new ArrayList<Integer>())) {
            res = Math.max(res, dfs(neighbor, informTime, g));
        }
        // 返回当前节点被通知需要的时间以及所有邻居节点被通知所需的最大时间
        return informTime[cur] + res;
    }

    public static void main(String[] args){
        int []manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int []informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        int headID = 0;
        int n = 15;
        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }
}