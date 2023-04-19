import java.util.ArrayList;


// ��С�����еļ۸��ܺ�(Hard)   ���⣺˼·������ȷ�����ǲ���д����

// ����˼·�������������ݽṹ�ǿ������޻���·��һ����Ψһ�ģ�BFS/DFS��
// ������Ѱ·��ͳ��·���и����ڵ���ֵ�Ƶ�� (��ϣ��)
// �ݹ�Ѱ�ҷ����ڽڵ��������ŷ���

// ����ֱ��˼·: 1. �����ڽڵ����-�뵽��ҽ����
// ��ҽ���� ������������
// ���ڵ㣺x 
// �ӽڵ㣺y
// x ѡ   y ��ѡ
// x ��ѡ max(yѡ��y��ѡ)

// todo 2. ���ϲ�� ����LCA


public class Solution{
    int [] counter; // ��¼Ƶ��
    ArrayList<Integer> adj [];  //�ڽӱ�
    int [] prices;  // ����۸���Ƶ�ʳ˻�

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        counter = new int[n];
        // �ڽӱ�
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
            // -1��ʾ����ע���ڵ�
            dfs(end,start,-1);
        }
        for(int i = 0; i < price.length;i++){
            price[i] = price[i]*counter[i];
        }
        prices = price;
        int [] ans = dfs(0, -1);
        return Math.min(ans[0],ans[1]);


    }
    // ͳ�ƽڵ�Ƶ��
    public boolean dfs(int end,int node,int father){
        // ��ǰ�ڵ����end��˵���Ѿ�����·���е�
        if(node == end){
            counter[node]++;
            return true;
        }
        for(int adjNode: adj[node]){
            //�ڽӽڵ㲻�Ǹ��ڵ㣬��dfs���ҵ�end˵�����м�ڵ�
            if(adjNode!=father &&dfs(end,adjNode,node)){
                counter[node]++;
                return true;
            }
        }
        return false;
    }
    // �ݹ�Ѱ�����Ž������
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