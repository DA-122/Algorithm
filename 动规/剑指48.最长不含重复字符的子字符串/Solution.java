// ��ָ Offer 48. ������ظ��ַ������ַ���
// ˼·����:dp + ��ϣ��
// dp[i] �Ե�i���ַ���β��������ַ�������
// dp[i] = dp[i-1]+1                   �ַ�iû���ֹ�
// dp[i] = min(dp[i-1]+1,i-map.get(i)) �ַ�i������
// ��ʼ��: dp[0] = 0;
// ����˳��:��ǰ����
import java.util.HashMap;
import java.util.Map;

public class Solution{
    public static int lengthOfLongestSubstring(String s) {
        int[] dp  = new int[s.length()+1];
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 1 ; i < dp.length; i++){
            char c = s.charAt(i-1);
            if(map.containsKey(c)){
                dp[i] = Math.min(i - map.get(c),dp[i-1]+1);
            }else{
                dp[i] = dp[i-1] + 1;
            }
            map.put(c,i);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    // ��������+��ϣ(��ʵ��dp˼·һ��)
    public static int lengthOfLongestSubstring2(String s) {
        int left = 0; int right = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            // c����
            if(map.containsKey(c)){
                //�Ա�left���ϴ�c���ֵ�λ��
                if(left <= map.get(c)){
                    left = map.get(c)+1;
                }
            }
            map.put(c,right);
            max = Math.max(max,right-left+1);
        }
        return max;
    }
    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}