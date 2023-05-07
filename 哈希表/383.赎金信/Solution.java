// 力扣383 赎金信
// 思路分析：哈希表
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] result = new int [26];
        for(int i = 0 ; i < magazine.length() ; i++){
            result[magazine.charAt(i) - 'a']++;
        }
        for(int j = 0;  j< ransomNote.length(); j++){
            result[ransomNote.charAt(j) - 'a']--;
            if(result[ransomNote.charAt(j) - 'a'] < 0)
                return false;
        }
        return true;
    }
}