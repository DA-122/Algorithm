// 1376.֪ͨ����Ա�������ʱ��
// ˼·����: (1)���仯�������������Ե����ϵı�������ϣ��洢�Ѿ���������ֵ  ʱ�临�Ӷ�O(N)���ռ临�Ӷ�O(N)
// (2) DFS��BFS ����manager���鹹����������ת��ΪѰ���·��  ʱ�临�Ӷ�O(N)���ռ临�Ӷ�O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution{
    // ���仯����
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < n; i++){
            // ����Ա��i�ӵ�֪ͨ��ʱ��
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
        // ʹ�� HashMap ������ͼ
        Map<Integer, List<Integer>> g = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            g.putIfAbsent(manager[i], new ArrayList<Integer>());
            g.get(manager[i]).add(i);
        }
        // �Ӹ��ڵ㿪ʼ���� DFS ��������ʱ��
        return dfs(headID, informTime, g);
    }

    public int dfs(int cur, int[] informTime, Map<Integer, List<Integer>> g) {
        int res = 0;
        // ������ǰ�ڵ���ھӽڵ�
        for (int neighbor : g.getOrDefault(cur, new ArrayList<Integer>())) {
            res = Math.max(res, dfs(neighbor, informTime, g));
        }
        // ���ص�ǰ�ڵ㱻֪ͨ��Ҫ��ʱ���Լ������ھӽڵ㱻֪ͨ��������ʱ��
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