import java.util.ArrayList;


// 最小化旅行的价格总和(Hard)   问题：思路基本正确，但是不会写代码

// 个人思路分析：首先数据结构是棵树，无环，路径一定是唯一的（BFS/DFS）
// 可以先寻路，统计路径中各个节点出现的频率 (哈希表)
// 递归寻找非相邻节点减半的最优方法

// 灵神直播思路: 1. 非相邻节点减半-想到打家劫舍Ⅲ
// 打家劫舍Ⅲ： 树上最大独立集
// 父节点：x 
// 子节点：y
// x 选   y 不选
// x 不选 max(y选、y不选)

// todo 2. 树上差分 离线LCA


public class Solution{
    int [] counter; // 记录频率
    ArrayList<Integer> adj [];  //邻接表
    int [] prices;  // 计算价格与频率乘积

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        counter = new int[n];
        // 邻接表
        adj  = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < edges.length; i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        for(int i = 0; i < trips.length;i++){
            int start = trips[i][0];
            int end = trips[i][1];
            // -1表示不关注父节点
            dfs(end,start,-1);
        }
        for(int i = 0; i < price.length;i++){
            price[i] = price[i]*counter[i];
        }
        prices = price;
        int [] ans = dfs(0, -1);
        return Math.min(ans[0],ans[1]);


    }
    // 统计节点频率
    public boolean dfs(int end,int node,int father){
        // 当前节点就是end，说明已经到达路径中点
        if(node == end){
            counter[node]++;
            return true;
        }
        for(int adjNode: adj[node]){
            //邻接节点不是父节点，且dfs能找到end说明是中间节点
            if(adjNode!=father &&dfs(end,adjNode,node)){
                counter[node]++;
                return true;
            }
        }
        return false;
    }
    // 递归寻找最优解决方案
    public int[] dfs(int node, int father){
        int []ans = new int[2];
        ans[0] = prices[node];
        ans[1] = prices[node]/2;
        for(int adjNode : adj[node]){
            if (adjNode!=father){
                int[] middleAns = dfs(adjNode,node);
                ans[0] += Math.min(middleAns[0],middleAns[1]);
                ans[1] += middleAns[0];
            }
        }
        return ans;
    }

}