import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    boolean [] visited;
    Map<Integer,List<Integer>> map = new HashMap<>();
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if(edges.length == 0){
            if(target == 1){
                return 1.0;
            } else{
                return 0.0;
            }
        }

        visited = new boolean[n+1];
        visited[1] = true;
        for(int i = 0; i < edges.length;i++){
            int start = edges[i][0];
            int end = edges[i][1];
            if(!map.containsKey(start)){
                map.put(start,new ArrayList<>());
            }
            if(!map.containsKey(end)){
                map.put(end,new ArrayList<>());
            }
            map.get(start).add(end);
            map.get(end).add(start);
        }
        return backtracing(edges,t,target,1,0);
    }


    public double backtracing(int[][]edges,int t, int target,int curNode,int curTime){
        List<Integer> list = map.get(curNode);
        // ��ʱ�����Ҷ�ӽڵ�
        if(curTime == t || list.size()== 1 && visited[list.get(0)]){
            if(curNode == target){
                return 1.0;
            }else{
                return 0.0;
            }
        }
        // ��ǰ�ڵ������һ�ڵ�ĸ���
        double unVisited = 0;
        // �����������ܸ���
        double probability = 0;
        for(int i = 0; i < list.size(); i++){
            int nextNode = list.get(i);
            // ���ʹ��Ľڵ㣬ֱ������
            if(visited[nextNode]){
                continue;
            }
            unVisited++;
            visited[nextNode] = true;
            probability +=backtracing(edges,t,target,nextNode,curTime+1);
            visited[nextNode] = false;
        }
        return probability*(1/unVisited);
    }
}