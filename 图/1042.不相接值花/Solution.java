// ����1042. ���ڽ�ֲ��
// ˼·������ ͼȾɫ����
public class Solution{
    public static int[] gardenNoAdj(int n, int[][] paths) {
        int ans[] = new int[n];
        // �������ڽӱ�
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
            // ͷ�ڵ�û����ֲ����,�������ڽӽڵ�����û���ֹ�������
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