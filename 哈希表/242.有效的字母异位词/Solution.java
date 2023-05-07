// 力扣242 有效的字母异位词
// 思路分析： 哈希表（数组即可）
class Solution {
    public boolean isAnagram(String s, String t) {
        boolean result = true;
        int[] alpha = new int[26];
        for(char word : s.toCharArray()){
            alpha[word-'a']++;
        }
        for(char word : t.toCharArray()){
            alpha[word-'a']--;
        }
        for(int num : alpha){
            if(num!=0){
                result = false;
            }
        }
        return result;
    }
}