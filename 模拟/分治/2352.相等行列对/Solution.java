// ����2352 ������ж�
// ˼·������
// ���� �㷨���Ӷ�O(n^3)
// �����ڱȽ�(ȥ��) ��ϣ�����м�Ƚ� �Ż���O(n^2)
public class Solution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>,Integer> map = new HashMap<>();
        int res = 0;
        // ��
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
