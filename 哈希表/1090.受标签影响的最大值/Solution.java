// ����1090.�ܱ�ǩӰ������ֵ
// ˼·������̰�ģ�����+��ϣ��ȥ��

public class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int [][] arr = new int[values.length][2];
        for(int i = 0; i < arr.length; i++){
            arr[i][0] = values[i];
            arr[i][1] = labels[i];
        }
        Arrays.sort(arr, (a,b) -> b[0] - a[0]);
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int cnt = 0;
        for(int i = 0; i < arr.length && cnt<numWanted; i++){
            int label = arr[i][1];
            int value = arr[i][0];
            if(map.containsKey(label)&&map.get(label) == useLimit ){
                continue;
            }
            map.put(label,map.getOrDefault(label,0)+1);
            result+=value;
            cnt++;
        }
        return result;

    }
}