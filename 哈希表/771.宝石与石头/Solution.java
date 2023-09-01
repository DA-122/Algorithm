// ����771. ��ʯ��ʯͷ
// ˼·��������ϣ��
// ʱ�临�Ӷ�O(m+n)���ռ临�Ӷ�O(m)
public class Solution{
    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for(char c : jewels.toCharArray()){
            set.add(c);
        }
        for(char c : stones.toCharArray()){
            if(set.contains(c)){
                res++;
            }
        }
        return res;
    }
}