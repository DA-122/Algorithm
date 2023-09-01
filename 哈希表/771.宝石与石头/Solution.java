// 力扣771. 宝石与石头
// 思路分析：哈希表
// 时间复杂度O(m+n)，空间复杂度O(m)
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