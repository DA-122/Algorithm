import java.util.ArrayList;

// 力扣1615 最大网络
// 思路分析：1.枚举，先根据数组统计所有节点的度，并在邻接表或者邻接矩阵中存储边信息，然后两两遍历统计网络秩
//          2.贪心，首先也是计算出所有节点的度，最大网络秩只会在最大度(first)和第二大度(second)节点中产生 first+second-1>others
//          所以需要记录最大度和第二大度以及对应的节点下标，假设度为first节点数量为x
//          (1) x = 1; 需要枚举second节点列表，如果找到first和一个second节点间无道路 return first+second 否则 return first+second-1
//          (2) x > 1; 如果有C(2,x) = x*(x-1)/2 > roads.length， 说明first节点中肯定存在一对节点之间没有道路， return first*2
//              否则 枚举first节点
// 复杂度分析:1.枚举：时间复杂度O(n^2)，空间复杂度,邻接表O(n+m),邻接矩阵O(n^2)
//           2.贪心 时间复杂度O(n)  空间复杂度 同上
class Solution {
    public static int maximalNetworkRank(int n, int[][] roads) {
        int max = 0;
        int dgree[] = new int[n];
        int graph[][] = new int[n][n];
        for(int i = 0 ; i < roads.length; i++){
            for(int j = 0; j < roads[0].length; j++){
                dgree[roads[i][j]]++;
            }
            if(roads[i][0] < roads[i][1]){
                graph[roads[i][0]][roads[i][1]] = 1;
            }else{
                graph[roads[i][1]][roads[i][0]] = 1;
            }
        }
        for(int i = 0; i < dgree.length; i++){
            for(int j = i+1; j < dgree.length; j++){
                max = Math.max(max,dgree[i]+dgree[j]-graph[i][j]);
            }
        }
        return max;
    }
    // 贪心算法
    public static int maximalNetworkRankGreedy(int n, int[][] roads) {
        int dgree[] = new int[n];
        int graph[][] = new int[n][n];
        for(int i = 0 ; i < roads.length; i++){
            for(int j = 0; j < roads[0].length; j++){
                dgree[roads[i][j]]++;
            }
                graph[roads[i][0]][roads[i][1]] = 1;
                graph[roads[i][1]][roads[i][0]] = 1;
        }
        int first = -1;
        int second = -2;
        ArrayList<Integer> arrayFir = new ArrayList<>();
        ArrayList<Integer> arraySec = new ArrayList<>();
        for(int i = 0; i < dgree.length; i++){
            if(first < dgree[i]){
                second = first;
                first = dgree[i];
                arraySec = new ArrayList<Integer>(arrayFir);
                arrayFir.clear();
                arrayFir.add(i);
            }else if(first == dgree[i]){
                arrayFir.add(i);
            }else{
                if(second < dgree[i]){
                    second = dgree[i];
                    arraySec.clear();
                    arraySec.add(i);
                }else if(second == dgree[i])
                    arraySec.add(i);
            }
        }
        if(arrayFir.size()==1){
            int firstPosition = arrayFir.get(0);
            for(int secondPosition: arraySec){
                    if(graph[secondPosition][firstPosition] == 0){
                        return first+second;
                }
            }
            return first+second-1;
        }else{
            int x = arrayFir.size();
            int num = x*(x-1)/2;
            // 如果最大度城市所能拥有的道路总数超过roads长度，说明肯定存在first之间没有道路相连
            if(num > roads.length){
                return first*2;
            }else{
                for(int i = 0; i < arrayFir.size(); i++){
                    for(int j = i+1; j < arrayFir.size(); j++){
                        if(graph[arrayFir.get(i)][arrayFir.get(j)]==0)
                            return first*2;
                    }
                }
                return first*2-1;
            }
        }
    }


    public static void main(String[] args){
        int [][] roads = {{0,1},{0,3},{1,2},{1,3}};
        int [][] roads2 = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};
        System.out.println(maximalNetworkRank(4, roads));
        System.out.println(maximalNetworkRankGreedy(5, roads2));
    }
}