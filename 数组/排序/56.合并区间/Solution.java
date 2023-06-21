// ����56.�ϲ�����
// ������Ȼ��ϲ�
// (a,b) (c, d)
// ����˵������ֻ��Ҫ������һ���������˵��Ƿ�С�ڵ�ǰ�����Ҷ˵�
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->(a[0] - b[0]));
        List<int[]> list = new ArrayList<>();
        int size = 0;
        for(int i = 0; i < intervals.length; i++){
            // �б�ջ��߲��ص�
            if(size == 0 || intervals[i][0] > list.get(size-1)[1]){
                list.add(intervals[i]);
                size++;
            }else{
                // �ϲ�����(�޸��Ҳ�߽�)
                list.get(size-1)[1] = Math.max(intervals[i][1],list.get(size-1)[1]);
            }
        }
        int [][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;

    }
}