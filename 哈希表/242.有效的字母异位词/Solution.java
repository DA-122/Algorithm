// ����242 ��Ч����ĸ��λ��
// ˼·������ ��ϣ�����鼴�ɣ�
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