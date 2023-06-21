// 力扣56.合并区间
// 先排序，然后合并
// (a,b) (c, d)
// 按左端点排序后，只需要考虑下一个区间的左端点是否小于当前区间右端点
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->(a[0] - b[0]));
        List<int[]> list = new ArrayList<>();
        int size = 0;
        for(int i = 0; i < intervals.length; i++){
            // 列表空或者不重叠
            if(size == 0 || intervals[i][0] > list.get(size-1)[1]){
                list.add(intervals[i]);
                size++;
            }else{
                // 合并操作(修改右侧边界)
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