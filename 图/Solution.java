import java.util.ArrayList;

// ����1615 �������
// ˼·������1.ö�٣��ȸ�������ͳ�����нڵ�Ķȣ������ڽӱ�����ڽӾ����д洢����Ϣ��Ȼ����������ͳ��������
//          2.̰�ģ�����Ҳ�Ǽ�������нڵ�Ķȣ����������ֻ��������(first)�͵ڶ����(second)�ڵ��в��� first+second-1>others
//          ������Ҫ��¼���Ⱥ͵ڶ�����Լ���Ӧ�Ľڵ��±꣬�����Ϊfirst�ڵ�����Ϊx
//          (1) x = 1; ��Ҫö��second�ڵ��б�����ҵ�first��һ��second�ڵ���޵�· return first+second ���� return first+second-1
//          (2) x > 1; �����C(2,x) = x*(x-1)/2 > roads.length�� ˵��first�ڵ��п϶�����һ�Խڵ�֮��û�е�·�� return first*2
//              ���� ö��first�ڵ�
// ���Ӷȷ���:1.ö�٣�ʱ�临�Ӷ�O(n^2)���ռ临�Ӷ�,�ڽӱ�O(n+m),�ڽӾ���O(n^2)
//           2.̰�� ʱ�临�Ӷ�O(n)  �ռ临�Ӷ� ͬ��
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
    // ̰���㷨
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
            // ������ȳ�������ӵ�еĵ�·��������roads���ȣ�˵���϶�����first֮��û�е�·����
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